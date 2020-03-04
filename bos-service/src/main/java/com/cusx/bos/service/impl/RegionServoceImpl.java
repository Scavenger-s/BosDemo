package com.cusx.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IRegionDao;
import com.cusx.bos.domain.Region;
import com.cusx.bos.service.IRegionService;
import com.cusx.bos.utils.PageBean;
@Service
@Transactional
public class RegionServoceImpl implements IRegionService {
	@Autowired
	private IRegionDao regionDao;
	/**
	 * 区域数据的批量保存
	 */

	public void saveBatch(List<Region> regionList) {
		for (Region region : regionList) {
			regionDao.saveOrUpdate(region);
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		
		regionDao.pageQuery(pageBean);
	}
	
	@Override
	public List<Region> findAll() {
		
		return regionDao.findAll();
	}
	/**
	 * 根据页面输入进行模糊查询
	 */
	public List<Region> findListByQ(String q) {
		return regionDao.findListByQ(q);
		
	}
	
}
