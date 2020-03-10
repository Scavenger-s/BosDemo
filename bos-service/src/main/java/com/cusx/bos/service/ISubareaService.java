package com.cusx.bos.service;

import java.util.List;

import com.cusx.bos.domain.Subarea;
import com.cusx.bos.utils.PageBean;

public interface ISubareaService {

	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);

	public List<Subarea> findAll();

	public List<Subarea> findListNotAssocation();

	public List<Subarea> findListByDecidedzoneId(String decidedzoneId);

}
