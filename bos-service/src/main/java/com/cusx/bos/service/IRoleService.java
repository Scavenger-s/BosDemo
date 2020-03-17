package com.cusx.bos.service;

import java.util.List;

import com.cusx.bos.domain.Role;
import com.cusx.bos.utils.PageBean;

public interface IRoleService {

	public void save(Role role, String functionIds);

	public void pageQuery(PageBean pageBean);

	public List<Role> findAll();

}
