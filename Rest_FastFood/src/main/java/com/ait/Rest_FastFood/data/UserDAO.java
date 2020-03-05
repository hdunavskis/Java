package com.ait.Rest_FastFood.data;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ait.Rest_FastFood.model.Customer;
import com.ait.Rest_FastFood.model.User;

@Stateless
@LocalBean
public class UserDAO {
	
	@PersistenceContext
    private EntityManager em;

	public Customer getCustomer(String userName) throws Exception{
		Query query = em.createQuery("Select u from Customer u where u.userName = ?1 ");
		query.setParameter(1, userName);
		if(query.getResultList().isEmpty()) {
			throw new Exception();
		}
		return (Customer) (query.getResultList().get(0));	
	}

}
