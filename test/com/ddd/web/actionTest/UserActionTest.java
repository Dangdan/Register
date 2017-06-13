package com.ddd.web.actionTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddd.web.DTO.UserRegisterInfo;
import com.ddd.web.action.UserAction;

public class UserActionTest {


	@Test
	public void testUserAction() throws Exception {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-bean.xml");
		UserAction ua=(UserAction) ctx.getBean("ua");
		UserRegisterInfo info=new UserRegisterInfo();
		
		info.setUsername("xxxx");
		info.setPassword("yyyyyy");
		info.setPassword2("eewq2");
		ua.setInfo(info);
		ua.execute();
		String ret = ua.execute();
		System.out.println(ret);
		
		
	}
	@Test
	public void testUserList(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-bean.xml");
		UserAction ua=(UserAction) ctx.getBean("user");
		ua.list();
		Assert.assertTrue((ua.getUsers().size()>0));;
		
	}

}
