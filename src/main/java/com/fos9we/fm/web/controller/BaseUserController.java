package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.User;
import com.fos9we.fm.bean.extend.UserExtend;
import com.fos9we.fm.service.IUserService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;
import com.fos9we.fm.vm.UserRoleVM;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: BaseUserController
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月30日 上午11:41:26 
 */
@Validated
@RestController
@RequestMapping("/baseUser")
public class BaseUserController {
   @Autowired
   private IUserService userService;
   
   @ApiOperation(value = "获取用户的基本信息")
   @GetMapping("findById")
   public Message findById(long id) {
		User findUserById = userService.findUserById(id);
		return MessageUtil.success(findUserById);
				
   }
   
   @ApiOperation(value = "对用户信息进行更新或者保存")
   @PostMapping("saveOrUpdate")
   public Message SaveOrUpdateUser(User user) {
	   userService.SaveOrUpdateUser(user);
	   return MessageUtil.success("更新成功");
   }
   
   
   @ApiOperation(value = "查询所有用户的基本信息")
   @GetMapping("findAll")
   public Message findAll() {
	   List<User> findAll = userService.findAll();
	   return MessageUtil.success(findAll);
   }
   
   
   @ApiOperation(value = "查询所有用户的基本信息(含角色信息)")
   @GetMapping("findAllWithRole")
   public Message findAllWithRole() {
	   List<UserExtend> findAllWithRole = userService.findAllWithRole();
	   return MessageUtil.success(findAllWithRole);
   }
   
   @ApiOperation(value = "通过id删除用户基本信息")
   @GetMapping("deleteById")
   public Message deleteById(long id) {
	   userService.deleteById(id);
	   return MessageUtil.success("删除成功");
   }
   
   @ApiOperation(value = "配置角色")
   @PostMapping("setRoles")
   public Message setRoles(UserRoleVM userRoleVM) {
	   userService.setRoles(userRoleVM.getId(), userRoleVM.getRoles());
	   return MessageUtil.success("设置成功");
   }
   
   @ApiOperation(value = "通过用户名那么查找用户基本信息")
   @GetMapping("findByName")
   public Message findByName(String name){
	   User findByName = userService.findByName(name);
	   return MessageUtil.success(findByName);
   }
}