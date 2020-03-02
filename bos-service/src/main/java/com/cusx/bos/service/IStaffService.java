package com.cusx.bos.service;

import com.cusx.bos.domain.Staff;
import com.cusx.bos.utils.PageBean;

public interface IStaffService {

	void save(Staff model);

	void pageQuery(PageBean pageBean);

}
