package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.extend.RoleExtend;
import com.fos9we.fm.service.IRoleService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;
import com.fos9we.fm.vm.RolePrivilegeVM;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: RoleController
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 上午10:20:07 
 */
@Validated
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private IRoleService roleService;
	
	@ApiOperation(value="通过用户id查找用户角色")
	@GetMapping("findByUserId")
	public Message findByUesrId(long id) {
		List<Role> findByUserId = roleService.findByUserId(id);
		return MessageUtil.success(findByUserId);
	}
	
	@ApiOperation(value="查找所有角色信息")
	@GetMapping("findAll")
	public Message findAll() {
		List<Role> findAll = roleService.findAll();
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="查找所有角色信息(级联查找权限)")
	@GetMapping("findAllRoleWithPrivilege")
	public Message findAllRoleWithPrivilege() {
		List<RoleExtend> findAll = roleService.findAllRoleWithPrivilege();
		return MessageUtil.success(findAll);
	}
	
	public Message deleteRoleById(long id) {
		roleService.deleteRoleById(id);
		return MessageUtil.success("删除成功");
	}
	  
   @ApiOperation(value = "给角色配置权限")
   @PostMapping("setPrivilegeToRole")
   public Message setPrivilegeToRole(RolePrivilegeVM rolePrivilegeVM) {
	   roleService.setPrivilegeToRole(rolePrivilegeVM.getId(), rolePrivilegeVM.getPrivilege());
	   return MessageUtil.success("设置成功");
   }
   @ApiOperation(value = "添加或更新角色")
   @PostMapping("saveOrUpdate")
   public Message saveOrUpdate(Role role) {
	   roleService.saveOrUpadate(role);
	   return MessageUtil.success("设置成功");
   }
   
    @ApiOperation(value="通过id删除角色")
	@GetMapping("deleteById")
	public Message deleteById(long id) {
    	roleService.deleteById(id);
    	return MessageUtil.success("删除成功");
	}
} 
