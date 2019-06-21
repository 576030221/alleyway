package com.alleyway.controller;

import com.alleyway.bean.User;
import com.alleyway.bean.UserGrade;
import com.alleyway.service.UserInformationService;
import com.alleyway.service.VerifyService;
import com.alleyway.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@Api(tags = "用户信息管理")
@RequestMapping("/information")
public class UserInformationController {

    private static Logger logger = LoggerFactory.getLogger(UserInformationController.class);

    @Autowired
    UserInformationService userInformationService;
    @Autowired
    VerifyService verifyService;

    /**
     * 用户名比较器 查询数据库中相同用户名的数量 用户名查重
     * @param userName
     * @return
     */
    @GetMapping("/comparatorUserName")
    @ApiOperation(value = "查找数据库中是否存在此用户名")
    public Result comparatorUserName(@ApiParam(value = "用户名",required = true) @RequestParam("userName") String userName){
        boolean is_repetition = userInformationService.comparatorUserName(userName);
        return  !is_repetition ? Result.success() : Result.failure("用户名已存在");

    }

    /**
     * 昵称比较器 查询数据库中相同用户的数量 昵称查重
     * @param nickname
     * @return
     */
    @GetMapping("/comparatorNickname")
    @ApiOperation(value = "查找数据库中是否存在此昵称")
    public Result comparatorNickname(@ApiParam(value = "昵称",required = true) @RequestParam("nickname") String nickname){
        boolean is_repetition = userInformationService.comparatorNickname(nickname);
        return  !is_repetition ? Result.success() : Result.failure("昵称已存在");
    }

    /**
     * 获取用户基本信息
     * @param userName 用户名
     * @param userPassWord 用户密码
     * @return
     */
    @GetMapping("/getUserData")
    @ApiOperation(value = "获取用户的基本信息")
    public Result getUserData(@ApiParam(value = "用户名",required = true) @RequestParam("userName") String userName,
                              @ApiParam(value = "密码",required = true) @RequestParam("userPassWord") String userPassWord){
        // 获取用户的基本信息
        User user = userInformationService.getUserData(userName,userPassWord);
        if (null == user) {
            return Result.failure("账号或密码有误！");
        }
        Result result = Result.success(user);
        return result;
    }

    /**
     * 获取用户的等级信息
     * @param userId    用户id
     * @return
     */
    @GetMapping("/getUserGrade")
    @ApiOperation(value = "获取用户的等级信息")
    public Result getUserGrade(@ApiParam(value = "用户id",required = true) @RequestParam("userId") String userId){
        // 获取用户的等级信息
        UserGrade userGrade = userInformationService.getUserGrade(Integer.valueOf(userId));
        Result result = Result.success(userGrade);
        return result;
    }

    /**
     * 获取用户的操作记录信息
     * @param userId    用户id
     * @return
     */
    @GetMapping("/getUserOperation")
    @ApiOperation(value = "获取用户的操作记录信息")
    public Result getUserOperation(@ApiParam(value = "用户id",required = true) @RequestParam("userId") String userId){
        if ( userId.isEmpty()) {
            return Result.failure("用户id为空");
        }
        // 获取用户的操作记录信息
        Map<String,int[]> operationMap = userInformationService.getUserOperation(Integer.valueOf(userId));
        Result result = Result.success(operationMap);
        return result;
    }

}
