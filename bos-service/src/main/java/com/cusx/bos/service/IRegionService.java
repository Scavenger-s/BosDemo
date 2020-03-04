package com.cusx.bos.service;

import java.util.List;

import com.cusx.bos.domain.Region;
import com.cusx.bos.utils.PageBean;

public interface IRegionService {

	void saveBatch(List<Region> regionList);

	void pageQuery(PageBean pageBean);

	List<Region> findAll();

	List<Region> findListByQ(String q);

	

	

}
