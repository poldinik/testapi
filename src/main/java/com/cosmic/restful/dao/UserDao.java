package com.cosmic.restful.dao;



import com.cosmic.restful.models.User;

import javax.ejb.Stateless;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;


@Stateless
@ApplicationScoped
public class UserDao {

	@PersistenceContext(unitName = "test", type= PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public void save(User user) {
		entityManager.persist(user);
	}
	
	public User findById(Long userId) {
		return entityManager.find(User.class, userId);
	}
	
	public User login(User user) {
		List<User> result = entityManager
					.createQuery("from User "
								+ "where email = :email "
								+ "and password = :pass", User.class)
					.setParameter("email", user.getEmail())
					.setParameter("pass", user.getPassword())
					.setMaxResults(1)
					.getResultList();
		
		if(result.isEmpty()) {
			return null;
		}
		
		return result.get(0);
	}
	
}
