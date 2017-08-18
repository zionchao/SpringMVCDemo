package com.kevin.learndemo.service.imp;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.kevin.learndemo.dao.UserDao;
import com.kevin.learndemo.entity.User;
import com.kevin.learndemo.entity.UserExample;
import com.kevin.learndemo.service.IRegisterService;

@Service("registerService")
public class RegisterServiceImpl implements IRegisterService {
	
	private static Logger logger=Logger.getLogger(RegisterServiceImpl.class);
	
	@Resource
	private UserDao userDao;

	public int insert(User record) {
		try{
			return userDao.insert(record);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int countByExample(UserExample example) {
		 try {  
	            return userDao.countByExample(example);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return 0;  
	}

}
