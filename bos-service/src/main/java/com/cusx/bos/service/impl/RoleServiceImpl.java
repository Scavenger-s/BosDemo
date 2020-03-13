package com.cusx.bos.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IRoleDao;
import com.cusx.bos.domain.Function;
import com.cusx.bos.domain.Role;
import com.cusx.bos.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao roleDao;
	@Override
	public void save(Role role, String functionIds) {
		roleDao.save(role);
		if(StringUtils.isNotBlank(functionIds)){
			String[] fIds = functionIds.split(",");
			for (String functionId : fIds) {
				//手动构造一个权限对象，设置id，对象状态为托管状态
				Function function = new Function(functionId);
				//角色关联权限
				role.getFunctions().add(function);
			}
		}

	}

}
