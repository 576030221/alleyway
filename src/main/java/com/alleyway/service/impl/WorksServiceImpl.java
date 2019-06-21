package com.alleyway.service.impl;

import com.alibaba.fastjson.JSON;
import com.alleyway.bean.*;
import com.alleyway.config.user_defined.FdfsConfig;
import com.alleyway.dao.*;
import com.alleyway.service.EmpiricalService;
import com.alleyway.service.RedisTemplateService;
import com.alleyway.service.WorksService;
import com.alleyway.utils.*;
import com.alleyway.utils.compressImg.CompressImgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WorksServiceImpl implements WorksService {

    @Autowired
    private WorksLabelMapper worksLabelMapper;
    @Autowired
    private WorksMapper worksMapper;
    @Autowired
    private WorksKeywordMapper worksKeywordMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private EmpiricalService empiricalService;
    @Autowired
    private RedisTemplateService redisTemplateService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private FastDFSUtil fileUtil;
    @Autowired
    private FdfsConfig fdfsConfig;
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private UserOperationMapper userOperationMapper;


    /**
     * 排序类型  当前为降序
     */
    private static final String ORDER_BY_TYPE = " desc";

    /**
     * 从redis中获取指定id的子分类，如果id为0，获取一级分类
     * @param parentId 父级id
     * @return
     */
    @Override
    public List<WorksLabel> getWorksLabelsAssignByReids(Integer parentId) {
        // 从redis中获取指定id分类信息
        String labelRedisJson = stringRedisTemplate.opsForValue().get("worksLabelsAssign_" + parentId);
        // 判断redis中是否有数据，如果没有，去数据库查询，并且更新redis
        if (labelRedisJson == null) {
	  return getWorksLabelsAssignToRedis(parentId);
        }
        // 将redis中取出的json转化为list返回
        List<WorksLabel> labelsList = GsonUtil.list4Json(labelRedisJson, WorksLabel.class);
        return labelsList;
    }

    /**
     * 获取指定的分类(从数据库)，传入0表示获取一级分类，传入一级id，表示根据一级id找二级
     * 存入redis
     * 如果删除或者添加了分类，就调用这个方法，更新redis
     * @return
     */
    @Override
    public List<WorksLabel> getWorksLabelsAssignToRedis(Integer id) {
        WorksLabelExample worksLabelExample = new WorksLabelExample();
        WorksLabelExample.Criteria criteria = worksLabelExample.createCriteria();
        // 根据父级id查询分类
        criteria.andParentIdEqualTo(id);
        List<WorksLabel> labelsList = worksLabelMapper.selectByExample(worksLabelExample);
        if (labelsList == null) {
            return null;
        }
        // 将查询出来的list转化为json存入redis中
        stringRedisTemplate.opsForValue().set("worksLabelsAssign_" + id,JSON.toJSONString(labelsList));
        return labelsList;

    }

    /**
     * 插入新的作品分类
     * @param parentId 父级id
     * @param content 分类名称
     * @return 插入是否成功
     */
    @Override
    public boolean saveWorksLabel(Integer parentId, String content) {
        // 判断欲插入的是否为一级标签
        if (!"0".equals(parentId)) {
            // 判断此父级id是否存在
            WorksLabel worksLabel = worksLabelMapper.selectByPrimaryKey(parentId);
            // 判断父级分类是否存在 || 判断父级分类是否为一级分类，如果不是不让插入
            if (worksLabel == null || !"0".equals(String.valueOf(worksLabel.getParentId()))) {
                return false;
            }
        }
        WorksLabel worksLabel = new WorksLabel();
        worksLabel.setContent(content);
        worksLabel.setParentId(parentId);
        int insertSize = worksLabelMapper.insert(worksLabel);
        if (insertSize == 0) {
            return false;
        }
        // 更新redis中的数据
        getWorksLabelsAssignToRedis(parentId);
        return true;
    }

    /**
     * 获取排好的两级分类
     * @return
     */
    @Override
    public List<WorksLabel> getWorksLabels() {
        // 获取所有的父级分类
        List<WorksLabel> labelsList = getWorksLabelsAssignByReids(0);
        if (labelsList == null) {
            return null;
        }
        for(int i = 0;i<labelsList.size();i++){
	  // 获取每个父级分类的子分类
	  WorksLabel worksLabel = labelsList.get(i);
	  List<WorksLabel> worksLabelsAssignByReids = getWorksLabelsAssignByReids(worksLabel.getId());
	  worksLabel.setSonLabel(worksLabelsAssignByReids);
        }
        return labelsList;
    }

    /**
     * 删除分类，根据分类的id
     * @param id 分类id
     * @return
     */
    @Override
    public boolean deleteWorksLabel(Integer id) {
        // 获取这个id的分类
        WorksLabel worksLabel = worksLabelMapper.selectByPrimaryKey(id);
        // 判断是否存在这个id
        if (worksLabel == null) {
            return false;
        }
        // 删除这个分类
        int deleteSize = worksLabelMapper.deleteByPrimaryKey(id);
        // 判断删除的这个分类是否为一级分类
        int parentId = worksLabel.getParentId();
        if (parentId != 0) {
            return true;
        }
        // 获取属于这个分类的所有二级分类
        List<WorksLabel> worksLabelsList = getWorksLabelsAssignByReids(worksLabel.getId());
        WorksLabelExample worksLabelExample = new WorksLabelExample();
        // 循环遍历，把这些二级分类的id拿出来，添加到where语句中，进行删除
        for (WorksLabel label : worksLabelsList) {
	  WorksLabelExample.Criteria criteria = worksLabelExample.createCriteria();
	  criteria.andIdEqualTo(label.getId());
	  worksLabelExample.or(criteria);
        }
        // 删除
        worksLabelMapper.deleteByExample(worksLabelExample);
        return true;
    }

    /**
     * 作品上传
     * @param userId 发布者id
     * @param labelId 分类id
     * @param title 标题
     * @param cover 封面拖
     * @param content 富文本作品内容
     * @return 返回插入的作品的id，如果返回0，插入表失败
     */
    @Override
    public int saveWorks(Integer userId, Integer labelId, String title, MultipartFile cover, String content) {
        Works works = new Works();
        // 用于存储插入的作品的id
        int worksId=0;
        try {
//	   压缩再上传
	  MultipartFile multipartFiles = CompressImgUtils.compressMultipartFile(cover);
	  String path = fileUtil.uploadFile(multipartFiles);
	  System.out.println(path);
	  works.setCoverPath(path);

	  // 用于存储最最终的结果
	  StringBuffer contentTextUltimately = new StringBuffer();
	  //
	  StringBuffer contentText = new StringBuffer(content);
	  // 前一次的下标
	  int last = 0;
	  // 当前遍历到的下标
	  int traverseSubscript = 0;
	  // 用于判断是否退出循环
	  boolean b = true;
	  while (b) {
	      // 找到图片标签，到前引号结束
	      int xb=contentText.indexOf("<img src=", traverseSubscript) + 10;
	      // 如果后面还有图片
	      if (xb != 9) {
		// 把当前遍历到的下标赋值进去
		traverseSubscript =xb;
		// 把前面那段字添加到最终字符串中
		contentTextUltimately.append(contentText.substring(last, traverseSubscript));
		// 把last也修改到当前位置
		last = traverseSubscript;
		// 找到img里最后的那个引号
		traverseSubscript = contentText.indexOf("\"", last);
		// 那么两个引号之间就是base64了
		String base64Code = contentText.substring(last, traverseSubscript);
		// 生成图片名称
		String headName=String.valueOf(UUIDUtil.getUUID());
		// 将图片的字节数组变成输入流，长传到文件服务器
		byte[] imgBytes = Base64Util.Base64StrToPNG(base64Code);
		InputStream bis = new BufferedInputStream( new ByteArrayInputStream(imgBytes) );
		String url = fileUtil.uploadFileStream(bis, headName);
		// 将返回的普通地址的后缀改成png，否则是乱码
		String suffix = url.substring(url.indexOf("."),url.length());
		url = url.replace(suffix,".png");
//		StringBuffer path1 = new StringBuffer(fdfsConfig.getWebServerUrl()).append(url);  // 在图片名称前拼接上绝对地址
		contentTextUltimately.append(url);
		last=contentText.indexOf("\"", traverseSubscript);
	      }else{
		b=false;
		contentTextUltimately.append(contentText.substring(traverseSubscript,contentText.length()));
	      }
	  }
	  works.setContent(contentTextUltimately.toString());

	  works.setUserId(userId);
	  works.setLabelId(labelId);
	  works.setTitle(title);
	  // 获取当前时间的字符串，封装
	  works.setAddTime(SqlDateUtil.nowDataTimeToString());
	  works.setLikeSize(0);
	  works.setCommentSize(0);
	  works.setCollectSize(0);
	  works.setAuditState(0);
	  works.setIsShow(1);
	  // 插入数据库
	  int insertSize = worksMapper.insert(works);
	  if (insertSize > 0) {
	      worksId = works.getId();
	  }
        } catch (Exception e) {
        }

        return worksId;
    }

    /**
     * 插入作品标签
     * @param worksId 作品id
     * @param content 多个标签的内容，用逗号分割
     * @return
     */
    @Override
    public boolean saveWorksKeyword(Integer worksId, String content) {
        // 将作品的拼接字符串分割成数组
        String[] contentArry = content.split(",");
        // 封装
        WorksKeyword worksKeyword = new WorksKeyword();
        // 因为标签属于的作品为同一个，所以这不在循环在中重复封装
        worksKeyword.setWorksId(worksId);
        // 遍历 插入
        for (String c : contentArry) {
            worksKeyword.setContent(c);
            worksKeywordMapper.insert(worksKeyword);
        }
        return true;
    }

    /**
     * 根据分类获取作品列表的数据
     * @param labelId 分类id，如果为0，表示全部分类都能拿到
     * @return
     */
    @Override
    public List<Works> getWorksList(Integer labelId) {
        WorksExample worksExample = new WorksExample();
        // 根据时间降序
        worksExample.setOrderByClause("add_time" + ORDER_BY_TYPE);

        // 如果想根据分类的id查询
        if (0 != labelId) {
	  WorksExample.Criteria criteria = worksExample.createCriteria();
	  criteria.andLabelIdEqualTo(labelId);
        }

        List<Works> worksList = worksMapper.selectByExample(worksExample);
        for (int i = 0; i <worksList.size();i++) {
	  // 将每个作品的封面的相对地址变成绝对地址
            worksList.get(i).setCoverPath(relativeToAbsolute(worksList.get(i).getCoverPath()));
        }
        return worksList;
    }


    /**
     * 单个图片 相对地址转绝对地址
     * 将fasetDFS中的相对地址，拼接上服务器的地址
     * @param relativePath
     * @return
     */
    @Override
    public String relativeToAbsolute(String relativePath) {
        return fdfsConfig.getWebServerUrl() + relativePath;
    }

    /**
     * 获取单个作品的详细信息，根据id
     * @param id
     * @return
     */
    @Override
    public Works getWorksById(Integer id) {
        // 从redis中获取指定id作品信息，转换为Works类型
        Works works = redisTemplateService.get("works_" + id, Works.class);
        // 如果redis中存在此id的weork，直接返回，否则去数据库查询
        if (works != null) {
	  return works;
        }
        // 获取这个id的作品
        works = worksMapper.selectByPrimaryKey(id);
        if (works == null) {
            return null;
        }
        // 将这个作品的内容中的图片相对地址转换为绝对地址
        works.setContent(contentImgToAbsolute(works.getContent()));
        // 将作品保存到redis中，设置过期时间为3小时，单位毫秒
        redisTemplateService.set("works_"+id,works);
        stringRedisTemplate.expire("works_"+id,1000*60*60*3,TimeUnit.MILLISECONDS);
        return works;
    }


    /**
     * 插入评论
     * @param userId 用户id
     * @param worksId 作品id
     * @param content 评论内容
     * @return
     */
    @Override
    public boolean saveComment(Integer userId, Integer worksId, String content) {
        // 封装评论，插入数据库
        Comment comment = new Comment();
        comment.setUserId(userId);
        comment.setWorksId(worksId);
        comment.setContent(content);
        comment.setAddTime(SqlDateUtil.nowDataTimeToString());
        comment.setDiscussLikeSize(0);
        commentMapper.insert(comment);
        return true;
    }

    /**
     * 发送回复
     * @param commentId 父级评论id
     * @param sendUsernickname 发送者昵称
     * @param receiveUsernickname 接收者昵称
     * @param content 回复的内容
     */
    @Override
    public boolean saveReply(Integer commentId, String sendUsernickname, String receiveUsernickname, String content) {
       Reply reply = new Reply();
       reply.setCommentId(commentId);
       reply.setSendUserNickname(sendUsernickname);
       reply.setReceiveUserNickname(receiveUsernickname);
       reply.setContent(content);
       reply.setAddTime(SqlDateUtil.nowDataTimeToString());
       replyMapper.insert(reply);
       return true;
    }

    /**
     * 删除评论
     * @param userId  用户id
     * @param commentId 评论id
     * @return
     */
    @Override
    public boolean deleteComment(Integer userId, Integer commentId) {
        // 根据评论id获取评论数据
        Comment comment = commentMapper.selectByPrimaryKey(commentId);
        // 判断评论是否存在，判断评论的发布者是否是现在这个用户
        if (comment == null || userId.equals(comment.getUserId())) {
            return false;
        }
        // 删除评论
        commentMapper.deleteByPrimaryKey(commentId);
        return true;
    }

    /**
     * 删除回复
     * @param replyId 回复id
     * @return
     */
    @Override
    public boolean deleteReply(Integer replyId) {
        replyMapper.deleteByPrimaryKey(replyId);
        return true;
    }

    /**
     * 点赞作品
     * @param userId 用户id
     * @param worksId 作品id
     * @return
     */
    @Override
    public boolean saveLikeWorks(Integer userId, Integer worksId) {
        // 查询是否存在这条记录
        UserOperationExample userOperationExample = new UserOperationExample();
        UserOperationExample.Criteria criteria = userOperationExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andTargetIdEqualTo(worksId);
        // 目标类型为作品1       操作类型为点赞1
        criteria.andTargetTypeEqualTo(1).andOperationTypeEqualTo(1);
        List<UserOperation> userOperations = userOperationMapper.selectByExample(userOperationExample);
        if (userOperations.size() != 0) {
            return false;
        }
        UserOperation userOperation = new UserOperation();
        userOperation.setUserId(userId);
        userOperation.setTargetId(worksId);
        userOperation.setTargetType(1);
        userOperation.setOperationType(1);
        int insert = userOperationMapper.insert(userOperation);
        return true;
    }

    /**
     * 收藏作品
     * @param userId 用户id
     * @param worksId 作品id
     * @return
     */
    @Override
    public boolean saveCollectWaorks(Integer userId, Integer worksId) {
        // 查询是否存在这条记录
        UserOperationExample userOperationExample = new UserOperationExample();
        UserOperationExample.Criteria criteria = userOperationExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andTargetIdEqualTo(worksId);
        // 目标类型为作品1       操作类型为收藏2
        criteria.andTargetTypeEqualTo(1).andOperationTypeEqualTo(2);
        List<UserOperation> userOperations = userOperationMapper.selectByExample(userOperationExample);
        if (userOperations.size() != 0) {
	  return false;
        }
        UserOperation userOperation = new UserOperation();
        userOperation.setUserId(userId);
        userOperation.setTargetId(worksId);
        userOperation.setTargetType(1);
        userOperation.setOperationType(2);
        int insert = userOperationMapper.insert(userOperation);
        return true;

    }

    /**
     * 点赞评论
     * @param userId 用户id
     * @param commentId 评论id
     * @return
     */
    @Override
    public boolean saveLikeComment(Integer userId, Integer commentId) {
        // 查询是否存在这条记录
        UserOperationExample userOperationExample = new UserOperationExample();
        UserOperationExample.Criteria criteria = userOperationExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andTargetIdEqualTo(commentId);
        // 目标类型为评论3       操作类型为点赞1
        criteria.andTargetTypeEqualTo(3).andOperationTypeEqualTo(1);
        List<UserOperation> userOperations = userOperationMapper.selectByExample(userOperationExample);
        if (userOperations.size() != 0) {
	  return false;
        }
        UserOperation userOperation = new UserOperation();
        userOperation.setUserId(userId);
        userOperation.setTargetId(commentId);
        userOperation.setTargetType(3);
        userOperation.setOperationType(1);
        int insert = userOperationMapper.insert(userOperation);
        return true;

    }

    /**
     * 将作品的内容中的图片地址变成绝对路径
     * @param content
     * @return
     */
    @Override
    public String contentImgToAbsolute(String content) {
        StringBuffer contextBuffer = new StringBuffer(content);
        // 获取fastDFS的服务器地址
        String path = fdfsConfig.getWebServerUrl();
        // 需要查找的内容，在这个后面跟服务器地址
        String seek = "img src=\"";
        int index = 0;
        boolean b = true;
        while (b){
	  index = contextBuffer.indexOf(seek,index);
	  if (index != -1) {
	      index += seek.length();
	      contextBuffer.insert(index,path);
	  }else {
	      b = false;
	  }
        }
        return contextBuffer.toString();
    }



}
