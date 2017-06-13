package com.ddd.ServiceTest;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ddd.Service.UserManager;
import com.ddd.Service.Impl.UserManagerImpl;
import com.ddd.entity.RUser;

public class UserManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testUserManager() throws SQLException {
		UserManager um=new UserManagerImpl();
		RUser u=new RUser();
		u.setName("wear");
		u.setPassword("14");
		boolean exist=um.exists(u);
		if(!exist)	um.add(u);
		else	System.out.println("the user exists!");
		//Assert.assertEquals(true, exist);
	}

}
