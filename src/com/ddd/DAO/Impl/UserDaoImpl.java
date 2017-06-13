package com.ddd.DAO.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.ddd.DAO.UserDao;
import com.ddd.DButil.HibernateUtil;
import com.ddd.entity.RUser;
@Component("userDao")
public class UserDaoImpl implements UserDao{
	private HibernateTemplate hibernateTemplate;


	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	public boolean save(RUser u) {
		if(!checkUserByName(u.getName())){
			hibernateTemplate.save(u);
			return true;
		}
		return false;
	}

	
	@Override
	public boolean checkUserByName(String username) {
		List<RUser> list=hibernateTemplate.find("from RUser u where u.name='"+username+"'");
		
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<RUser> getUsers() {
		return (List<RUser>)this.hibernateTemplate.find("from RUser");
	}

	@Override
	public RUser loadUserById(int i) {
		
		return (RUser) this.hibernateTemplate.load(RUser.class, i);
	}

}
