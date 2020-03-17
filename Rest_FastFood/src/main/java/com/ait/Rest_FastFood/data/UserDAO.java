package com.ait.Rest_FastFood.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ait.Rest_FastFood.model.User;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext
    private EntityManager em;

	public User getCustomer(String userName){
		 @SuppressWarnings("unchecked")
		List<User> users = em.createQuery("Select u from User u where u.userName = :username ")
				.setParameter("username", userName)
				.getResultList();
		 if(users.isEmpty()) {
			 return null;
		 }
		 return users.get(0);
	}
	public void save(User user){
		em.persist(user);
	}
}
