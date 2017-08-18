package com.kevin.learndemo.service;

import com.kevin.learndemo.entity.User;
import com.kevin.learndemo.entity.UserExample;

public interface IRegisterService {
	
	public int insert(User record);
	
	public int countByExample(UserExample example);

}
