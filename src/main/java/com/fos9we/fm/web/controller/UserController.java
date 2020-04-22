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
   public User findById(long id) {
	   return userService.findUserById(id);
   }
}
