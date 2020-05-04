/**
 * 
 */
package com.fos9we.fm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.service.IUserService;
import com.fos9we.fm.utils.JwtTokenUtil;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;
import com.fos9we.fm.vm.UserRoleVM;
import com.fos9we.fm.vm.UserVM;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: UserController
 *@Description: 用户控制类
 * @author Administrator
 *@date 2020年4月17日 下午4:50:07 
 */

@Validated
@RestController
@RequestMapping("/vue-element-admin/user")
public class UserController {
   @Autowired
   private IUserService userService;
   @ApiOperation(value = "用户登录")
   @PostMapping("login")
   public Message login(@RequestBody UserVM userVM) {
	   //认证用户名和密码
	   User user = userService.login(userVM);
	   //如果成功，产生token，将token缓存起来，返回
	   String token = JwtTokenUtil.createJWT(user.getId(), user.getName());
	   Map<String,String> map = new HashMap<>();
	   map.put("token", token);
	   return MessageUtil.success(map);
	   
   }
   @ApiOperation(value = "通过token获取用户信息(含角色)")
   @GetMapping("info")
   public Message info(String token) {
	   // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
	   long id = Long.parseLong(JwtTokenUtil.getUserId(token, JwtTokenUtil.base64Secret));
	   UserExtend findUserExtendById = userService.findUserExtendById(id);
	   return MessageUtil.success(findUserExtendById);
   } 
   
   @ApiOperation(value = "用户退出登录")
   @PostMapping("logout")
   public Message logout() {
	   return MessageUtil.success("退出成功");
   }
   
   
}
