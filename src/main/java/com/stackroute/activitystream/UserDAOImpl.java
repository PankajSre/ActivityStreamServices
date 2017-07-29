package com.stackroute.activitystream;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();

		}
		return false;
	}

	public User validateUser(String emailId, String password) {

		String hql = "from User where emailId= '" + emailId + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	public User getUserByEmailId(String emailId) {

		User user = (User) sessionFactory.getCurrentSession().createQuery("from User where emailId='" + emailId + "'")
				.uniqueResult();
		return user;
	}

	public boolean deleteUser(User user) {

		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {

			e.printStackTrace();
		}
		return false;
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

}
