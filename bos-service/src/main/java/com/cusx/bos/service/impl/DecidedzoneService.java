package com.cusx.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IDecidedzoneDao;
import com.cusx.bos.dao.ISubareaDao;
import com.cusx.bos.domain.Decidedzone;

import com.cusx.bos.domain.Subarea;
import com.cusx.bos.service.IDecidedzoneService;
import com.cusx.bos.utils.PageBean;
@Service
@Transactional
public class DecidedzoneService implements IDecidedzoneService{
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;
	@Override
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//model.getSubareas().add(subarea);一方（定区）已经放弃维护外键权利，只能由多方（分区）负责维护
			subarea.setDecidedzone(model);//分区关联定区
		}
		
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
		
	}

}
