/**
 * 
 */
package com.fos9we.fm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.service.IUserService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

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
}
