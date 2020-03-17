package com.cusx.bos.service;

import java.util.List;

import com.cusx.bos.domain.Function;
import com.cusx.bos.utils.PageBean;

public interface IFunctionService {

	public List<Function> findAll();

	public void save(Function model);

	public void pageQuery(PageBean pageBean);

	public List<Function> findMenu();

}
