package com.cusx.bos.dao;

import com.cusx.bos.dao.base.IBaseDao;
import com.cusx.bos.domain.User;

public interface IUserDao extends IBaseDao<User>{

	public User findUserByUsernameAndPassword(String username, String password);

	public User findUserByUsername(String username);

}
