package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.dao.RolePrivilegeMapper;
import com.fos9we.fm.dao.extend.RolePrivilegeExtendMapper;
import com.fos9we.fm.service.IRolePrivilegeService;

/**
 *@ClassName: RolePrivilegeServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年5月4日 上午10:42:05 
 */
@Service
public class RolePrivilegeServiceImpl implements IRolePrivilegeService{
	@Resource
	RolePrivilegeExtendMapper rolePrivilegeExtendMapper;
	@Override
	public List<Privilege> cascadeFindByRoleId(long id) {
		List<Privilege> privileges = rolePrivilegeExtendMapper.cascadeFindByRoleId(id);
		return privileges;
	}

}
