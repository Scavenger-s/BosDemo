package com.cusx.bos.dao;

import java.util.List;

import com.cusx.bos.dao.base.IBaseDao;
import com.cusx.bos.domain.Function;

public interface IFunctionDao extends IBaseDao<Function> {

	List<Function> findFunctionListByUserId(String id);

	List<Function> findAllMenu();

	List<Function> findMenuByUserId(String id);

}
