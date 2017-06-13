package com.ddd.Service.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.ddd.DAO.UserDao;
import com.ddd.DAO.Impl.UserDaoImpl;
import com.ddd.Service.UserManager;
import com.ddd.entity.RUser;

public class UserManagerImpl implements UserManager{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public boolean exists(RUser u){
		return userDao.checkUserByName(u.getName()); 
	}
	public boolean add(RUser u){
		return userDao.save(u);
		
	}
	@Override
	public List<RUser> getUsers() {
		return this.userDao.getUsers();
	}
	@Override
	public RUser loadUser(int i) {
		return this.userDao.loadUserById(i);
	}
	
}
