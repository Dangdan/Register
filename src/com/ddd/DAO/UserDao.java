package com.ddd.DAO;

import java.util.List;

import com.ddd.entity.RUser;

public interface UserDao {
	boolean checkUserByName(String username);
	boolean save(RUser u);
	List<RUser> getUsers();
	RUser loadUserById(int i);
	

}
