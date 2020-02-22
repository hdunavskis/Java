package com.ait.Rest_FastFood.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ait.Rest_FastFood.model.Food;

@Stateless
@LocalBean
public class FoodDAO {
	
	@PersistenceContext
    private EntityManager em;

	public List<Food> getAllFood(){
		Query query=em.createQuery("SELECT f FROM Food f");
        return query.getResultList();
	}

}
