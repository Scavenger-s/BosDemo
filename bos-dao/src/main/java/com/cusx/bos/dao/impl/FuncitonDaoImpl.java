package com.cusx.bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cusx.bos.dao.IDecidedzoneDao;
import com.cusx.bos.dao.IFunctionDao;
import com.cusx.bos.dao.base.impl.BaseDaoImpl;
import com.cusx.bos.domain.Decidedzone;
import com.cusx.bos.domain.Function;

@Repository
public class FuncitonDaoImpl extends BaseDaoImpl<Function> implements IFunctionDao{
	public List<Function> findAll() {
		String hql = "FROM Function f WHERE f.parentFunction IS NULL";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql);
		return list;
	}
}
