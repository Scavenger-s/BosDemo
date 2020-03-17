package com.cusx.bos.dao.base.impl;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cusx.bos.dao.base.IBaseDao;
import com.cusx.bos.utils.PageBean;

/**
 * 持久层通用实现
 * @author lh
 *
 * @param <T>
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	//代表的是某个实体的类型
	private Class<T> entityClass;
	
	@Resource//根据类型注入spring工厂中的会话工厂对象sessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	//在父类（BaseDaoImpl）的构造方法中动态获得entityClass
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类上声明的泛型数组
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}
	
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	public List<T> findAll() {
		String hql = "FROM " + entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

	/**
	 * 执行更新
	 */
	@Override
	public void executeUpdate(String queryName, Object... objs) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		int i = 0;
		for (Object object : objs) {
			//为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
		
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		int currentPage = pageBean.getCurrentPage();
		int pageSize = pageBean.getPageSize();
		DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
		//查询total
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		Long count = countList.get(0);
		pageBean.setTotal(count.intValue());
		//查询rows
		detachedCriteria.setProjection(null);
		detachedCriteria.setResultTransformer(detachedCriteria.ROOT_ENTITY);
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
		pageBean.setRows(rows);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
		
	}

	@Override
	public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
		
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
	}
}
