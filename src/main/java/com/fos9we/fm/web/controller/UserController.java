/**
 * 
 */
package com.fos9we.fm.web.controller;

import java.util.HashMap;
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
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;
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
@RequestMapping("/user")
public class UserController {
   @Autowired
   private IUserService userService;
   
//====================================基础用户功能==========================================
   @ApiOperation(value = "获取用户的基本信息")
   @GetMapping("findById")
   public Message findById(long id) {
		User findUserById = userService.findUserById(id);
		return MessageUtil.success(findUserById);
				
   }
   
   @ApiOperation(value = "对用户信息进行更新或者保存")
   @GetMapping("saveOrUpdate")
   public Message SaveOrUpdateUser(User user) {
	   userService.SaveOrUpdateUser(user);
	   return MessageUtil.success("更新成功");
   }
   
//=================================用户登录验证相关功能========================================
   @ApiOperation(value = "用户登录")
   @PostMapping("login")
   public Message login(@RequestBody UserVM userVM) {
	   //认证用户名和密码
	   //如果成功，产生token，将token缓存起来，返回
	   Map<String,String> map = new HashMap<>();
	   map.put("token", "admin-token");
	   return MessageUtil.success(map);
	   
   }
   @ApiOperation(value = "通过token获取用户信息(含角色)")
   @GetMapping("info")
   public Message info(String token) {
	   //// 1. 通过token获取用户信息  {id,use,gender,roles:[]}
	   UserExtend findUserExtendById = userService.findUserExtendById(1L);
	   return MessageUtil.success(findUserExtendById);
   }
   @ApiOperation(value = "用户退出登录")
   @PostMapping("logout")
   public Message logout() {
	   return MessageUtil.success("退出成功");
   }
   
   
}
