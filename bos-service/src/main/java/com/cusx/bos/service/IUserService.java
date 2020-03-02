package com.cusx.bos.service;

import com.cusx.bos.domain.User;

public interface IUserService {

	public User login(User model);

	public void editPassword(String id, String password);

}
