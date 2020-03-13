package com.cusx.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IFunctionDao;
import com.cusx.bos.domain.Function;
import com.cusx.bos.service.IFuncitonService;
import com.cusx.bos.utils.PageBean;
@Service
@Transactional
public class FuncitonServiceImpl implements IFuncitonService {
	@Autowired
	private IFunctionDao functionDao;
	@Override
	public List<Function> findAll() {
		return functionDao.findAll();
		
	}
	
	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		if(parentFunction != null && parentFunction.getId().equals("")) {
			model.setParentFunction(null);
		}
		functionDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		
		
		functionDao.pageQuery(pageBean);
		
	}
	

}
