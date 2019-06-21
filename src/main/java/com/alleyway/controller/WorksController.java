package com.alleyway.controller;

import com.alleyway.bean.Works;
import com.alleyway.bean.WorksLabel;
import com.alleyway.service.EmpiricalService;
import com.alleyway.service.WorksService;
import com.alleyway.utils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe: 作品模块的所有东西，评论，分类，关键字
 *
 * @author: 洪
 */
@RestController
@Api(tags = "作品模块")
@RequestMapping("/works")
public class WorksController {

    @Autowired
    private WorksService worksService;
    @Autowired
    private EmpiricalService empiricalService;


    @PostMapping("/saveWorks")
    @ApiOperation(value = "添加作品")
    public Result saveWorks(@ApiParam(value = "发布者id",required = true) @RequestParam("userId") Integer userId,
		        @ApiParam(value = "分类id",required = true) @RequestParam("labelId") Integer labelId,
		        @ApiParam(value = "作品标题",required = true) @RequestParam("title") String title,
		        @ApiParam(value = "封面图片",required = true) @RequestParam("cover") MultipartFile cover,
		        @ApiParam(value = "作品内容，富文本格式",required = true) @RequestParam("content") String content){
        // 插入作品，返回插入成功的作品的id
        int b = worksService.saveWorks(userId,labelId,title,cover,content);
        // 如果返回的不是0，表示成功，，返回0，表示插入失败
        if (b != 0) {
            Map<String,Object> map = new HashMap<>(3);
            map.put("worksId",b);
            // 判断是否满足增加经验的条件，并且增加经验
            empiricalService.verifyOperationNumber(userId,1);
            return Result.success(map);
        }
        return Result.failure();
    }

    @PostMapping("/saveWorksKeyword")
    @ApiOperation(value = "添加作品关键字")
    public Result saveWorksKeyword(@ApiParam(value = "作品id",required = true) @RequestParam("worksId") Integer worksId,
			     @ApiParam(value = "多个关键字，英文逗号分割",required = true) @RequestParam("content") String content){
        // 插入关键字
        boolean b = worksService.saveWorksKeyword(worksId,content);
        return b ? Result.success() : Result.failure();
    }

    @GetMapping("/getWorksList")
    @ApiOperation(value = "获取作品列表（全部分类）")
    public Result getWorksList(@ApiParam(value = "页码 （默认1）",required = true) @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			 @ApiParam(value = "每页显示条数 （默认10）",required = true) @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			 @ApiParam(value = "连续显示页数 （默认5）",required = true) @RequestParam(value = "showPageNum", defaultValue = "5") Integer showPageNum,
			 @ApiParam(value = "分类id （默认全部分类）",required = true) @RequestParam(value = "labelId", defaultValue = "0") Integer labelId){
        // 配制分页信息
        PageHelper.startPage(pageNum,pageSize);
        // 查询数据
        List<Works> worksList = worksService.getWorksList(labelId);
        if (worksList == null) {
            return Result.failure("获取不到数据");
        }
        // 封装分页信息
        PageInfo pageInfo = new PageInfo(worksList,showPageNum);
        // 封装结果信息
        return Result.success(pageInfo);
    }

    @GetMapping("/getWorks")
    @ApiOperation(value = "获取作品详细信息（根据作品ID）")
    public Result getWorks(@ApiParam(value = "作品id",required = true) @RequestParam("id") Integer id){
        Works works = worksService.getWorksById(id);
        if (works == null) {
            return Result.failure("id有误");
        }
        return Result.success(works);
    }

    @PostMapping("/saveComment")
    @ApiOperation(value = "发布评论")
    public Result saveComment(@ApiParam(value = "用户id",required = true) @RequestParam("userId") Integer userId,
			@ApiParam(value = "作品id",required = true) @RequestParam("worksId") Integer worksId,
			@ApiParam(value = "评论内容",required = true) @RequestParam("content") String content,
			HttpServletRequest request){
        // 判断发布评论的用户id和登陆的用户是否是同一个，防止恶意调用接口
        if (judgeUserId(userId,request)) {
	  return Result.failure("请输入正确的用户id");
        }
        boolean b = worksService.saveComment(userId,worksId,content);
        if (!b) {
            return Result.failure();
        }
        // 判断是否满足增加经验的条件，并且增加经验
        empiricalService.verifyOperationNumber(userId,2);
        return Result.success();
    }

    @PostMapping("/saveReply")
    @ApiOperation(value = "发布回复")
    public Result saveReply(@ApiParam(value = "用户id",required = true) @RequestParam("userId") Integer userId,
		        @ApiParam(value = "父级评论id",required = true) @RequestParam("commentId") Integer commentId,
		        @ApiParam(value = "发送者昵称",required = true) @RequestParam("sendUsernickname") String sendUsernickname,
		        @ApiParam(value = "接收者昵称",required = true) @RequestParam("receiveUsernickname") String receiveUsernickname,
		        @ApiParam(value = "回复内容",required = true) @RequestParam("content") String content,
		        HttpServletRequest request){
        // 判断发布评论的用户id和登陆的用户是否是同一个，防止恶意调用接口
        if (judgeUserId(userId,request)) {
	  return Result.failure("请输入正确的用户id");
        }
        boolean b = worksService.saveReply(commentId, sendUsernickname, receiveUsernickname, content);
        if (!b) {
	  return Result.failure();
        }
        // 判断是否满足增加经验的条件，并且增加经验
        empiricalService.verifyOperationNumber(userId,2);
        return Result.success();
    }

    @DeleteMapping("/deleteComment")
    @ApiOperation(value = "删除评论")
    public Result deleteComment(@ApiParam(value = "用户id",required = true) @RequestParam("userId") Integer userId,
			  @ApiParam(value = "评论id",required = true) @RequestParam("commentId") Integer commentId,
			  HttpServletRequest request){
        // 判断调用接口的用户id和登陆的用户是否是同一个，防止恶意调用接口
        if (judgeUserId(userId,request)) {
	  return Result.failure("请输入正确的用户id");
        }
        // 删除评论
        boolean b = worksService.deleteComment(userId,commentId);
        return b ? Result.success() : Result.failure("用户id或者评论id有误");
    }

    @DeleteMapping("/deleteReply")
    @ApiOperation(value = "删除回复")
    public Result deleteReply(@ApiParam(value = "回复id",required = true) @RequestParam("replyId") Integer replyId){
        boolean b = worksService.deleteReply(replyId);
        return Result.success();
    }

    @GetMapping("/getComment")
    @ApiOperation(value = "获取评论与回复（分页）")
    public Result getComment(){
        return Result.success();
    }

    @PostMapping("/savelikeWorks")
    @ApiOperation(value = "点赞作品")
    public Result saveLikeWorks(@ApiParam(value = "用户id",required = true) @RequestParam("userId") Integer userId,
			  @ApiParam(value = "作品id",required = true) @RequestParam("worksId") Integer worksId,
			  HttpServletRequest request){
        // 判断调用接口的用户id和登陆的用户是否是同一个，防止恶意调用接口
        if (judgeUserId(userId,request)){
	  return Result.failure("请输入正确的用户id");
        }
        // 插入数据（判断书否已经存在数据）
        boolean b = worksService.saveLikeWorks(userId,worksId);
        return b ? Result.success() : Result.failure("已经给此作品点过赞");
    }

    @PostMapping("/collectWorks")
    @ApiOperation(value = "收藏作品")
    public Result saveCollectWaorks(@ApiParam(value = "用户id",required = true) @RequestParam("userId") Integer userId,
			      @ApiParam(value = "作品id",required = true) @RequestParam("worksId") Integer worksId,
			      HttpServletRequest request){
        // 判断调用接口的用户id和登陆的用户是否是同一个，防止恶意调用接口
        if (judgeUserId(userId,request)) {
	  return Result.failure("请输入正确的用户id");
        }
        boolean b = worksService.saveCollectWaorks(userId,worksId);
        return Result.success();
    }

    @PostMapping("/likeComment")
    @ApiOperation(value = "点赞评论")
    public Result saveLikeComment(@ApiParam(value = "用户id",required = true) @RequestParam("userId") Integer userId,
			    @ApiParam(value = "评论id",required = true) @RequestParam("commentId") Integer commentId,
			    HttpServletRequest request){
        // 判断调用接口的用户id和登陆的用户是否是同一个，防止恶意调用接口
        if (judgeUserId(userId,request)) {
	  return Result.failure("请输入正确的用户id");
        }
        boolean b = worksService.saveLikeComment(userId,commentId);
        return Result.success();
    }

    @GetMapping("/getWorksLabels")
    @ApiOperation(value = "获取所有作品分类")
    public Result getWorksLabels(){
        List<WorksLabel> list = worksService.getWorksLabels();
        return list != null ? Result.success(list) : Result.failure("获取分类失败");
    }

    @GetMapping("/getWorksLabelsTop")
    @ApiOperation(value = "获取所有一级作品分类")
    public Result getWorksLabelsTop(){
        List<WorksLabel> labels = worksService.getWorksLabelsAssignByReids(0);
        if (labels != null) {
	  return Result.success(labels);
        }
        return Result.failure("获取分类失败");
    }

    @GetMapping("/getWorksLabelsSecondary")
    @ApiOperation(value = "获取指定一级中的二级作品分类")
    public Result getWorksLabelsSecondary(@ApiParam(value = "一级分类ID",required = true) @RequestParam("parentId") Integer parentId){
        List<WorksLabel> labels = worksService.getWorksLabelsAssignByReids(parentId);
        if (labels != null) {
	  return Result.success();
        }
        return Result.failure("父级ID有误");
    }

    @PostMapping("/saveWorksLabel")
    @ApiOperation(value = "插入新的作品分类")
    public Result saveWorksLabel(@ApiParam(value = "父级分类ID，如需插入一级分类，此处填0",required = true) @RequestParam("parentId") Integer parentId,
                                @ApiParam(value = "分类名称内容",required = true) @RequestParam("content") String content){
        // 插入。返回是否插入成功
        boolean b = worksService.saveWorksLabel(parentId,content);
        if (b) {
            return Result.success();
        }
        return Result.failure("父级ID有误");
    }
    // cheshi
    @DeleteMapping("/deleteWorksLabel")
    @ApiOperation(value = "删除作品分类")
    public Result deleteWorksLabel(@ApiParam(value = "分类的id",required = true) @RequestParam("id") Integer id){
        boolean b = worksService.deleteWorksLabel(id);
        if (b) {
	  return Result.success();
        }
        return Result.failure("id有误");
    }

    /**
     * 判断传递进来的用户id是否与登录的用户id是同一个
     * session里的userId是在登录的时候存进去的
     *
     * @param userId 用户id
     * @param request
     * @return
     */
    private boolean judgeUserId(Integer userId , HttpServletRequest request){
        if (userId == null) {
            return false;
        }
        return userId.equals((Integer) request.getSession().getAttribute("userId"));
    }

}
