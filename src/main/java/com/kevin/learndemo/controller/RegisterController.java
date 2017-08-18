package com.kevin.learndemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.kevin.learndemo.entity.User;
import com.kevin.learndemo.entity.UserExample;
import com.kevin.learndemo.entity.UserExample.Criteria;
import com.kevin.learndemo.service.IRegisterService;

@Controller
public class RegisterController {
	private static Logger logger = Logger.getLogger(RegisterController.class); 
	
	@Resource
	private IRegisterService registerService;
	
	@RequestMapping({"/register","/"})
	public String register(){
		return "register";
	}
	
	@RequestMapping(value="/register/checkUserName",method=RequestMethod.POST)
	public String checkUserName(HttpServletRequest request,HttpServletResponse response){
		String userName=request.getParameter("userName");
		//检测用户名是否存在
		UserExample userExample=new UserExample();
		Criteria conditionCri=userExample.createCriteria();
		 int num=registerService.countByExample(userExample);  
	        //用户名是否存在的标志  
	        boolean flag=false;  
	        if(num>0){  
	            flag=true;  
	        } 
	    
	    Map<String,Object> map=new HashMap<String,Object >();
	     map.put("flag", flag);
	     Gson gson=new Gson();
	     String json=gson.toJson(map);
	     
	     response.setCharacterEncoding("UTF-8");
	     try {
			response.flushBuffer();
			 response.getWriter().write(json);
			 response.getWriter().flush();
			 response.getWriter().close();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
	  return null;
	}
	
	@RequestMapping(value="/register/checkEmail",method = RequestMethod.POST)  
    public String checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException{  
        String email=(String)request.getParameter("email");           
        //检验邮箱是否存在  
        UserExample userExample=new UserExample();  
        Criteria conditionCri = userExample.createCriteria();  
        conditionCri.andUserEmailEqualTo(email);          
        int num=registerService.countByExample(userExample);  
        //用户名是否存在的标志  
        boolean flag=false;  
        if(num>0){  
            flag=true;  
        }         
        //将数据转换成json  
        Map<String,Object> map = new HashMap<String,Object>();    
        map.put("flag", flag);              
        Gson gson=new Gson();
	     String json=gson.toJson(map);        
        //将数据返回  
        response.setCharacterEncoding("UTF-8");  
        response.flushBuffer();  
        response.getWriter().write(json);  
        response.getWriter().flush();    
        response.getWriter().close();  
        return null;  
    }
	
	 @RequestMapping(value="/register/successed")  
	    public ModelAndView  successed(HttpServletRequest request, HttpServletResponse response) throws IOException{  
	        String username=(String)request.getParameter("username");     
	        String email=(String)request.getParameter("email");       
	        String password=(String)request.getParameter("password");  
	        if(username==null||email==null||password==null){  
	            return new ModelAndView("redirect:/register");   
	        }  
	        //新增用户插入数据库  
	        User user=new User();  
	        user.setUserName(username);  
	        user.setUserEmail(email);  
	        user.setUserPassword(password);  
	        registerService.insert(user);         
	        //将数据转换成  
	        Map<String,Object> map = new HashMap<String,Object>();    
	        map.put("username", username);    
	        map.put("email", email);    
	        map.put("password", password);    
	/*      String json = JSONObject.fromObject(map).toString();         
	        //将数据返回 
	        response.setCharacterEncoding("UTF-8"); 
	        response.flushBuffer(); 
	        response.getWriter().write(json); 
	        response.getWriter().flush();   
	        response.getWriter().close();*/  
	        return new ModelAndView("successed",map);    
	    }  
	
}
