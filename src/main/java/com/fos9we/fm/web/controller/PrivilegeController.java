package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.bean.extend.PrivilegeExtend;
import com.fos9we.fm.service.IPrivilegeService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;
import com.fos9we.fm.vm.RolePrivilegeVM;
import com.fos9we.fm.vm.UserRoleVM;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: PrivilegeController
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 下午8:11:44 
 */
@Validated
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
	@Autowired
	IPrivilegeService privilegeService;
	
	@ApiOperation(value="查找所有权限信息")
	@GetMapping("findAll")
	public Message findAll() {
		List<Privilege> findAll = privilegeService.findAll();
		return MessageUtil.success(findAll);
	}
	
	@ApiOperation(value="通过parentId查找权限信息")
	@GetMapping("findByParentId")
	public Message findByParentId(long id) {
		List<Privilege> findByParentId = privilegeService.findByParentId(id);
		return MessageUtil.success(findByParentId);
	}
	
	@ApiOperation(value="保存或更新权限信息")
	@PostMapping("saveOrUpdate")
	public Message saveOrUpdate(Privilege privilege) {
		privilegeService.saveOrUpdate(privilege);
		return MessageUtil.success("更新成功");
	}
	@ApiOperation(value="级联查到子权限")
	@GetMapping("findAllWithChildren")
	public Message findAllWithChildren() {
		List<PrivilegeExtend> findALlWithChildren = privilegeService.findALlWithChildren();
		return MessageUtil.success(findALlWithChildren);
	}
	@ApiOperation(value="查找一级权限(除己方父类权限)")
	@GetMapping("findParentPrivilege")
	public Message findParentPrivilege(long id){
		List<Privilege> findParentPrivilege = privilegeService.findParentPrivilege(id);
		return MessageUtil.success(findParentPrivilege);
		
	}
	@ApiOperation(value="查找所有一级权限")
	@GetMapping("findAllFirst")
	public Message findAllFirst(){
		List<Privilege> findAllFist = privilegeService.findAllFist();
		return MessageUtil.success(findAllFist);
		
	}
}
