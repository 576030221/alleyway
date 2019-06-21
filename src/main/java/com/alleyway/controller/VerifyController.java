package com.alleyway.controller;

import com.alleyway.bean.User;
import com.alleyway.service.EmpiricalService;
import com.alleyway.service.UserInformationService;
import com.alleyway.service.VerifyService;
import com.alleyway.utils.MD5Util;
import com.alleyway.utils.Result;
import com.alleyway.utils.comparator.ContentJudgeUtil;
import io.swagger.annotations.*;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.misc.ConstructorUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@Api(tags = "用户权限管理")
@RequestMapping("/verify")
public class VerifyController {

    private static Logger logger = LoggerFactory.getLogger(VerifyController.class);

    @Autowired
    VerifyService verifyService;
    @Autowired
    UserInformationService userInformationService;
    @Autowired
    EmpiricalService empiricalService;

    /**
     * 发送手机验证码
     * @param userPhone
     * @param request
     * @return
     */
    @PostMapping("/getPhoneVerify")
    @ApiOperation(value = "发送手机验证码")	// swagger 文档中对此方法的说明提示
    @ApiResponses(value = {
	  @ApiResponse(code = 4,message = "手机号格式有误"),
	  @ApiResponse(code = 5,message = "手机号已存在")
    })
    public Result getPhoneVerify(@ApiParam(value = "手机号",required = true) @RequestParam("userPhone") String userPhone,
			   HttpServletRequest request){
        if (!ContentJudgeUtil.isPhoneNumber(userPhone)) {
	  return Result.failure(4,"手机号格式有误");
        }
        // 判断手机号是否已经被注册过了
        boolean b = userInformationService.comparatorUserPhone(userPhone);
        if (b) {
            return Result.failure(5,"手机号已存在");
        }
        // 获取用户ip
        String ip = request.getRemoteAddr();
        String code = verifyService.getPhoneVerify(userPhone,ip);
        if (code != null) {
	  request.getSession().setAttribute("phone",userPhone);
            request.getSession().setAttribute("phoneCode",code);
            return Result.success();
        }
	return Result.failure("验证码发送失败");
    }


    /**
     * 用户注册
     * @param userName
     * @param userPhone
     * @param userPassWord
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "注册（普通用户）")
    @ApiResponses(value = {
	  @ApiResponse(code = 4,message = "用户名不能为手机号"),
	  @ApiResponse(code = 5,message = "手机号发生改变(在发送手机验证码后，手机号被修改了)"),
	  @ApiResponse(code = 6,message = "验证码有误"),
	  @ApiResponse(code = 7,message = "用户名已存在")
    })
    public Result register(@ApiParam(value = "手机号",required = true) @RequestParam("userPhone") String userPhone,
		       @ApiParam(value = "手机验证码",required = true) @RequestParam("code") String code,
		       @ApiParam(value = "用户名",required = true) @RequestParam("userName") String userName,
                           @ApiParam(value = "密码",required = true) @RequestParam("userPassWord") String userPassWord,
		       HttpServletRequest request){
        // 用户名不能为手机号格式
        if (ContentJudgeUtil.isPhoneNumber(userName)) {
	  return Result.failure(4,"用户名不能为手机号");
        }
        // 判断手机号是否是刚刚发验证码的手机号
        String phone = (String) request.getSession().getAttribute("phone");
        if (!userPhone.equals(phone)) {
	  return Result.failure(5,"手机号发生改变(在发送手机验证码后，手机号被修改了)");
        }
        // 判断验证码是否正确
        String phoneCode = (String) request.getSession().getAttribute("phoneCode");
        if (!code.equals(phoneCode)) {
            return Result.failure(6,"验证码有误");
        }
        // 判断用户名是否存在
        boolean b = userInformationService.comparatorUserName(userName);
        if (b) {
	  return Result.failure(7,"用户名已存在");
        }

        // 插入用户表
        int userId = verifyService.register(userPhone,userName,userPassWord);
        Result result;
        if (userId != 0) {
             result = Result.success();
            // 初始化此用户在用户等级表中的数据
            verifyService.enteringUserGradeTable(userId);
        }else {
            result = Result.failure("注册失败");
        }
        logger.warn("注册成功，用户ID为： " + userId);
        // 注册成功，将session中的验证码清空，防止用户返回注册界面重复注册
        request.getSession().setAttribute("phoneCode","");
        return result;
    }

    /**
     * 用户登录
     * @param account 用户名或手机号
     * @param userPassWord 密码
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登录（普通用户）")
    public Result login(@ApiParam(value = "用户名或手机号",required = true) @RequestParam("account") String account,
                        @ApiParam(value = "密码",required = true) @RequestParam("userPassWord") String userPassWord,
                        HttpServletRequest request){

        // 判断用户名密码是否正确
        User user = verifyService.login(account,MD5Util.getMD5(userPassWord));
        if (null == user) {
            return Result.failure("账号或密码有误！");
        }
        // 判断是否为当天首次登录，获得每日登录经验，并且升级
        empiricalService.verifyOperationNumber(user.getId(),4);
        // 在session存存放一个键值对，上传东西时，判断那时session有无此键值对，即可知道他有没有调用过登录接口了
        HttpSession session = request.getSession();
        session.setAttribute("status","");
        session.setAttribute("userId",user.getId());
        session.setMaxInactiveInterval(86400);
        return Result.success("登录成功，若要获取用户信息请调用另外一个接口");
    }

    /**
     * 用户登录 密文  用于自动登录
     * @param userName 用户名
     * @param userPassWord 加密密码
     * @return
     */
    @PostMapping("/loginEncryption")
    @ApiOperation(value = "登录 加密密码,用于自动登录")
    public Result loginEncryption(@ApiParam(value = "用户名",required = true) @RequestParam("userName") String userName,
                        @ApiParam(value = "加密密码",required = true) @RequestParam("userPassWord") String userPassWord,
                        HttpServletRequest request){

        // 判断用户名密码是否正确
        User user = verifyService.login(userName,userPassWord);
        if (null == user){
            return Result.failure("登录失败");
        }
        // 判断是否为当天首次登录，获得每日登录经验，并且升级
        empiricalService.verifyOperationNumber(user.getId(),4);
        // 在session存存放一个键值对，上传东西时，判断那时session有无此键值对，即可知道他有没有调用过登录接口了
        HttpSession session = request.getSession();
        session.setAttribute("status","");
        session.setMaxInactiveInterval(86400);
        return Result.success("登录成功，若要获取用户信息请调用另外一个接口");
    }
}
