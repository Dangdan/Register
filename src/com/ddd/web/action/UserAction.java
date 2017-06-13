package com.ddd.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ddd.Service.UserManager;
import com.ddd.Service.Impl.UserManagerImpl;
import com.ddd.entity.RUser;
import com.ddd.web.DTO.UserRegisterInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component("ua")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven {
	/*这是直接接受jsp的信息
		private String username;
		private String password;
		private String password2; 
	 */
	
	
	//使用DTO(Data Transfer Object)封装前台传来的数据
	private UserRegisterInfo info=new UserRegisterInfo();
	private UserManager userManager;
	public UserManager getUserManager() {
		return userManager;
	}
	@Resource
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	private List<RUser> users;
	
	private RUser user;
	public RUser getUser() {
		return user;
	}
	public void setUser(RUser user) {
		this.user = user;
	}
	public List<RUser> getUsers() {
		return users;
	}
	public void setUsers(List<RUser> users) {
		this.users = users;
	}
	

	@Override
	public String execute() throws Exception {
		System.out.println(info.getUsername());
		RUser u=new RUser();
		u.setName(info.getUsername());
		u.setPassword(info.getPassword());
		if(userManager.add(u))
			return "success";
		return "fail";
	}
	public UserRegisterInfo getInfo() {
		return info;
	}
	public void setInfo(UserRegisterInfo info) {
		this.info = info;
	}
	@Override
	public Object getModel() {
		return info;
	}
	
	public String list(){
		this.users=userManager.getUsers();
		return "users";
	}
	public String load(){
		this.user=userManager.loadUser(info.getId());
		return "load";
	}
	
}
