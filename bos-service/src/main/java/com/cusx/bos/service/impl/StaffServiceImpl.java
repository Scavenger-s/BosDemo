package com.cusx.bos.service.impl;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IStaffDao;
import com.cusx.bos.domain.Staff;
import com.cusx.bos.service.IStaffService;
import com.cusx.bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;
	@Override
	public void save(Staff model) {
		
		staffDao.save(model);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
	/**
	 * 取派员批量删除
	 */
	@Override
	public void deleteBatch(String ids) {
		if(StringUtils.isNotBlank(ids)){
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
		
	}
	
	/**
	 * 根据id查询取派员
	 */
	public Staff findById(String id) {
		
		return staffDao.findById(id);
	}
	
	/**
	 * 根据id修改
	 */
	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
		
	}

}
