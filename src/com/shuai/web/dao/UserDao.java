package com.shuai.web.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shuai.web.entity.User;

@Repository
public class UserDao implements IUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
		//需要flush，否则添加不成功
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		//from  User  User代表你定义的javaBean User.java
		String hql="from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		String hql="DELETE FROM User WHERE ID =?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (query.executeUpdate()>0);
	}


	@Override
	public User getSingleUser(String id) {
		// TODO Auto-generated method stub
		String hql = "from User where id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return (User) query.uniqueResult();
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
//		String hql="User u set u.usersName=?,u.age=? where u.id=?";
		String sql = "UPDATE T_User SET usersName='"+user.getUsersName()+"' ,age='"+user.getAge()+"' WHERE id='"+user.getId()+"'";
		System.out.println(sql);
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql);
//		query.setString(0, user.getId());
//		query.setString(1, user.getAge());
//		query.setString(2, user.getUsersName());
		return query.executeUpdate()>0;
	}

}
