package com.cusx.bos.dao;

import java.util.List;

import com.cusx.bos.dao.base.IBaseDao;
import com.cusx.bos.domain.Staff;
import com.cusx.bos.domain.Subarea;

public interface ISubareaDao extends IBaseDao<Subarea>{

	List<Object> findSubareasGroupByProvince();

}
