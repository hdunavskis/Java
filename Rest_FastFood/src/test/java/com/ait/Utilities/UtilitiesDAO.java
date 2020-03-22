package com.ait.Utilities;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ait.Rest_FastFood.model.Order;

@LocalBean
@Stateless
public class UtilitiesDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void deleteOrders() {
		em.createQuery("DELETE FROM Order").executeUpdate();
	}
	public void insertOrders(Order order) {
		em.persist(order);
	}
	public void deleteUsers() {
		em.createQuery("DELETE FROM User").executeUpdate();
	}
}
