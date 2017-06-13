package com.ddd.Service;

import java.util.List;

import com.ddd.entity.RUser;

public interface UserManager {
	public boolean exists(RUser u);
	public boolean add(RUser u);
	public List<RUser> getUsers();
	public RUser loadUser(int i);
}
