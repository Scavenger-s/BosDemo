package com.cusx.bos.service.impl;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cusx.bos.dao.IUserDao;
import com.cusx.bos.domain.User;
import com.cusx.bos.service.IUserService;
import com.cusx.bos.utils.MD5Utils;


@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao userDao;
	/***
	 * 用户登录
	 */
	public User login(User user) {
		//使用MD5加密密码
		String password = MD5Utils.md5(user.getPassword());
		return userDao.findUserByUsernameAndPassword(user.getUsername(),password);
	}
	
	/**
	 * 根据用户id修改密码
	 * @throws IOException 
	 */
	
	public void editPassword(String id, String password)  {
		
		String md5password = MD5Utils.md5(password);
		
			
		userDao.executeUpdate("user.editpassword", md5password,id);
		
	}
	
	
}
