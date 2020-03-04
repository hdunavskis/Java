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

	public List<Order> getAllOrders(){
		Query query=em.createQuery("SELECT o FROM Order o");
        return query.getResultList();
	}
	
	public void placeAnOrder(Order order){
		em.persist(order);	
	}

	public void update(Order order) {
		em.merge(order);
	}

	public Order getSingleOrder(int orderId) throws Exception{
		Order order = em.find(Order.class, orderId);
		if(order == null) {
			throw new Exception();
		}
		return order;	
	}
}
