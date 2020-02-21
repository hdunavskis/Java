package com.ait.Rest_FastFood.util;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ait.Rest_FastFood.model.Food;


@Stateless
@LocalBean
public class UtilsDAO {

    @PersistenceContext
    private EntityManager em;
    
	public void deleteTables(){
		//em.createQuery("DELETE FROM Customer").executeUpdate();
		em.createQuery("DELETE FROM Food").executeUpdate();
	//	em.createQuery("DELETE FROM Order").executeUpdate();
		//em.createQuery("DELETE FROM KitchenStaff").executeUpdate();
	}
	public void postFood(Food food){
		em.persist(food);
	}
      
}

