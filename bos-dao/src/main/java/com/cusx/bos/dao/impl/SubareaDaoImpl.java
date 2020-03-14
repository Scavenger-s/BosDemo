package com.cusx.bos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cusx.bos.dao.ISubareaDao;
import com.cusx.bos.dao.base.impl.BaseDaoImpl;
import com.cusx.bos.domain.Staff;
import com.cusx.bos.domain.Subarea;
import com.cusx.bos.utils.PageBean;
@Repository
public class SubareaDaoImpl extends  BaseDaoImpl<Subarea>  implements ISubareaDao {

	@Override
	public List<Object> findSubareasGroupByProvince() {
		String hql = "SELECT r.province ,count(*) FROM Subarea s LEFT OUTER JOIN s.region r Group BY r.province";
		return (List<Object>) this.getHibernateTemplate().find(hql);
	}

	

}
