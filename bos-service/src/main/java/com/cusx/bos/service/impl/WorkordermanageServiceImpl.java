package com.cusx.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IWorkordermanageDao;
import com.cusx.bos.domain.Workordermanage;
import com.cusx.bos.service.IUserService;
import com.cusx.bos.service.IWorkordermanageService;

@Service
@Transactional
public class WorkordermanageServiceImpl implements IWorkordermanageService{
	@Autowired
	private IWorkordermanageDao workordermanageDao;
	@Override
	public void save(Workordermanage model) {
		
		workordermanageDao.save(model);
	}

}
