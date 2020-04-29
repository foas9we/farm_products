package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Role;
import com.fos9we.fm.bean.RoleExample;
import com.fos9we.fm.bean.extend.RoleExtend;
import com.fos9we.fm.dao.RoleMapper;
import com.fos9we.fm.dao.extend.ProductExtendMapper;
import com.fos9we.fm.dao.extend.RoleExtendMapper;
import com.fos9we.fm.service.IRoleService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: RoleServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 上午10:18:21 
 */
@Service
public class RoleServiceImpl implements IRoleService{
	@Resource
	private RoleExtendMapper roleExtendMapper;
	@Resource
	private RoleMapper roleMapper;
	@Override
	public List<Role> findByUserId(long id) {
		return roleExtendMapper.findByUserId(id);
	}
	
	@Override
	public List<Role> findAll() {
		return roleMapper.selectByExample(new RoleExample());
	}

	@Override
	public List<RoleExtend> findAllRoleWithPrivilege() {
		return roleExtendMapper.findAllRoleWithPrivilege();
	}

	@Override
	public void deleteRoleById(long id) throws CustomerException {
		Role role = roleMapper.selectByPrimaryKey(id);
		if(role==null) {
			throw new CustomerException("该角色不存在");
		}
		roleMapper.deleteByPrimaryKey(id);
	}

}
