package com.cusx.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.ISubareaDao;
import com.cusx.bos.domain.Subarea;
import com.cusx.bos.service.ISubareaService;
import com.cusx.bos.utils.PageBean;
@Service
@Transactional
public class SubareaService implements ISubareaService {
	@Autowired
	private ISubareaDao subareaDao;

	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
		
	}

	@Override
	public List<Subarea> findAll() {
		
		return subareaDao.findAll();
	}

	/**
	 * 查询所有未关联到分区
	 */
	public List<Subarea> findListNotAssocation() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		
		return subareaDao.findByCriteria(detachedCriteria );
	}
	/**
	 * 根据定区id查询关联的分区
	 */
	@Override
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.eqOrIsNull("decidedzone.id", decidedzoneId));
		
		return subareaDao.findByCriteria(detachedCriteria );
	}
}
