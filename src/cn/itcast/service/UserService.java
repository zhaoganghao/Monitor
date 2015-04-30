package cn.itcast.service;

import cn.itcast.bean.User;
import cn.itcast.service.base.DAO;

public interface UserService extends  DAO<User>{

	boolean checkUser(String username, String password);
	public User find(String username) ;
	
}
