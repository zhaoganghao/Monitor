package cn.itcast.service.impl;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bean.User;
import cn.itcast.service.UserService;
import cn.itcast.service.base.DaoSupport;
import cn.itcast.utils.MD5;
@Service
@Transactional
public class UserServiceImpl extends DaoSupport<User> implements UserService{

	@Override
	public boolean checkUser(String username, String password) {
		Long count=(Long) this.em.createQuery("select count(o) from User o where username = ? and password = ?")
		.setParameter(1, username).setParameter(2, MD5.MD5Encode(password)).getSingleResult();
		return count>0;
	}

	public User find(String username) {
		User user=(User) this.em.createQuery(" from User o where username = ? ")
				.setParameter(1, username).getSingleResult();
		return user;
	}

	@Override
	public void save(User entity) {
		entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		super.save(entity);
	}

	@Override
	public void update(User entity) {
		entity.setPassword(MD5.MD5Encode(entity.getPassword()));
		super.update(entity);
	}
	
}
