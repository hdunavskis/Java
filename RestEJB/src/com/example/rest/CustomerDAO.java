package com.example.rest;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CustomerDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Customer getCustomer(int id) {
        return em.find(Customer.class, id);
    }
    public List<Customer> getAllCustomers() {
    	
    	Query query = em.createQuery("SELECT c FROM Customer c");
    	
    	return query.getResultList();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            em.persist(customer);
        }
    }
    
}
