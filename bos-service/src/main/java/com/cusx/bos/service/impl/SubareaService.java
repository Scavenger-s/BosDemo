package com.cusx.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.ISubareaDao;
import com.cusx.bos.domain.Subarea;
import com.cusx.bos.service.ISubareaService;
@Service
@Transactional
public class SubareaService implements ISubareaService {
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
		
	}
}
