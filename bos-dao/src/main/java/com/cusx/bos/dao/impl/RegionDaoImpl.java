package com.cusx.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cusx.bos.dao.IRegionDao;
import com.cusx.bos.dao.IStaffDao;
import com.cusx.bos.dao.base.impl.BaseDaoImpl;
import com.cusx.bos.domain.Region;
import com.cusx.bos.domain.Staff;

@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements IRegionDao{

	/**
	 * 根据q进行模糊查询
	 */
	public List<Region> findListByQ(String q) {
		String hql = "FROM Region r WHERE r.shortcode LIKE ? "
				+ "	OR r.citycode LIKE ? OR r.province LIKE ? "
				+ "OR r.city LIKE ? OR r.district LIKE ?";
		List<Region> list = (List<Region>) this.getHibernateTemplate().
		find(hql, "%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%","%"+q+"%");
		return list;
		
	}

}
