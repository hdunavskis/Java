package com.ait.Rest_FastFood.data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ait.Rest_FastFood.model.Customer;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext
    private EntityManager em;

	public Customer getCustomer(String userName){
		return (Customer) em.createQuery("Select u from Customer u where u.userName = :username ")
				.setParameter("username", userName)
				.getResultList()
				.get(0);
	}
}
