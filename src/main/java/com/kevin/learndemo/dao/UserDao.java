package com.kevin.learndemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kevin.learndemo.entity.User;
import com.kevin.learndemo.entity.UserExample;

public interface UserDao {
	
	int countByExample(UserExample example);
	
	int deleteByExample(UserExample example);
	
	int deleteByPrimaryKey(Integer userId);
	
	int insert(User record);
	
	int insertSelective(User record);
	
	List<User> selectByExample(UserExample exampe);
	
	 User selectByPrimaryKey(Integer userId);  
	  
	    /** 
	     * This method was generated by MyBatis Generator. 
	     * This method corresponds to the database table t_user 
	     * 
	     * @mbggenerated 
	     */  
	    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);  
	  
	    /** 
	     * This method was generated by MyBatis Generator. 
	     * This method corresponds to the database table t_user 
	     * 
	     * @mbggenerated 
	     */  
	    int updateByExample(@Param("record") User record, @Param("example") UserExample example);  
	  
	    /** 
	     * This method was generated by MyBatis Generator. 
	     * This method corresponds to the database table t_user 
	     * 
	     * @mbggenerated 
	     */  
	    int updateByPrimaryKeySelective(User record);  
	  
	    /** 
	     * This method was generated by MyBatis Generator. 
	     * This method corresponds to the database table t_user 
	     * 
	     * @mbggenerated 
	     */  
	    int updateByPrimaryKey(User record);  
	

}
