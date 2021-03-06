package com.cusx.bos.dao;

import java.util.List;

import com.cusx.bos.dao.base.IBaseDao;
import com.cusx.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region>{

	public  List<Region> findListByQ(String q);

}
