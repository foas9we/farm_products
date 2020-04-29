package com.fos9we.fm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fos9we.fm.bean.Privilege;
import com.fos9we.fm.bean.PrivilegeExample;
import com.fos9we.fm.dao.PrivilegeMapper;
import com.fos9we.fm.service.IPrivilegeService;
import com.fos9we.fm.utils.CustomerException;

/**
 *@ClassName: PrivilegeServiceImpl
 *@Description: TODO
 * @author Administrator
 *@date 2020年4月29日 下午8:08:41 
 */
@Service
public class PrivilegeServiceImpl implements IPrivilegeService{
	@Resource
	PrivilegeMapper privilegeMapper;
	
	@Override
	public List<Privilege> findAll() {
		return privilegeMapper.selectByExample(new PrivilegeExample());
	}

	@Override
	public List<Privilege> findByParentId(Long id) {
		PrivilegeExample example = new PrivilegeExample();
		if(id==null) {
			example.createCriteria().andParentIdIsNull();
		}
		example.createCriteria().andParentIdEqualTo(id);
		List<Privilege> selectByExample = privilegeMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public void saveOrUpdate(Privilege privilege) throws CustomerException {
		if(privilege.getId()!=null) {
			privilegeMapper.updateByPrimaryKeySelective(privilege);
		}
		else {
			privilegeMapper.insertSelective(privilege);
		}
	}

	
	
}
