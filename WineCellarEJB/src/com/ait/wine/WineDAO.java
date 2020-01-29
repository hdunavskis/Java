package com.ait.wine;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Stateless
@LocalBean
public class WineDAO {

    @PersistenceContext
    private EntityManager em;
    
	public List<Wine> getAllWines() {
    	Query query=em.createQuery("SELECT w FROM Wine w");
        return query.getResultList();
    }
      
}
