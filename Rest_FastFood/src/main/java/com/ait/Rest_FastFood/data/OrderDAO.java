package com.ait.Rest_FastFood.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.ait.Rest_FastFood.model.Order;

@Stateless
@LocalBean
public class OrderDAO {
	
	@PersistenceContext
    private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders(){
		return em.createQuery("SELECT o FROM Order o")
        		.getResultList();
	}
	
	public void placeAnOrder(Order order){
		em.persist(order);	
	}

	public void update(Order order) {
		em.merge(order);
	}

	public Order getSingleOrder(int orderId){
		return em.find(Order.class, orderId);	
	}
	
	public void removeOrder(int orderId){
		em.remove(getSingleOrder(orderId));	
	}
}
