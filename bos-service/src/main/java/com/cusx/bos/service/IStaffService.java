package com.cusx.bos.service;

import java.util.List;

import com.cusx.bos.domain.Staff;
import com.cusx.bos.utils.PageBean;

public interface IStaffService {

	void save(Staff model);

	void pageQuery(PageBean pageBean);

	void deleteBatch(String ids);

	Staff findById(String id);

	void update(Staff staff);

	List<Staff> findNotDelete();

}
