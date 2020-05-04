package com.fos9we.fm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.service.IRolePrivilegeService;
import com.fos9we.fm.utils.Message;
import com.fos9we.fm.utils.MessageUtil;

import io.swagger.annotations.ApiOperation;

/**
 *@ClassName: RolePrivilegeController
 *@Description: TODO
 * @author Administrator
 *@date 2020年5月4日 上午10:45:42 
 */
@Validated
@RestController
@RequestMapping("/rolePrivilege")
public class RolePrivilegeController {
	@Autowired
	IRolePrivilegeService rolePrivilegeService;
	
	@ApiOperation(value="通过角色id级联查找权限(包含级联查找子权限)")
	@GetMapping("cascadeFindByRoleId")
	public Message cascadeFindByRoleId(long id) {
		List<Privilege> cascadeFindByRoleId = rolePrivilegeService.cascadeFindByRoleId(id);
		return MessageUtil.success(cascadeFindByRoleId);
	}
}
