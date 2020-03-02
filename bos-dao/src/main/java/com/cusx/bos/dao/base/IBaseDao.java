package com.cusx.bos.dao.base;

import java.io.Serializable;
import java.util.List;

import com.cusx.bos.utils.PageBean;

/**
 * 持久层通用接口
 * @author Scavengers
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
	public	void executeUpdate(String queryName, Object...objs);
	public void pageQuery(PageBean pageBean);
}
