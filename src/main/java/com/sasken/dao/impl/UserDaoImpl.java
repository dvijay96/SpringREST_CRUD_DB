package com.sasken.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sasken.dao.UserDao;
import com.sasken.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	protected SessionFactory factory;

	public void addUser(User user) throws Exception {

		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteUserById(int id) {

		Session session = factory.openSession();
		session.beginTransaction();
		User user = (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

	public User getUserById(int id) {

		Session session = factory.openSession();
		session.beginTransaction();
		User user = (User) session.createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
		session.getTransaction().commit();
		session.close();
		return user;
	}

	public List<User> getAllUsers() {

		Session session = factory.openSession();
		session.beginTransaction();
		List<User> users =session.createCriteria(User.class).list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

}
