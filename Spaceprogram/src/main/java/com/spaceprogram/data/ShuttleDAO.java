package com.spaceprogram.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.spaceprogram.model.Shuttle;

@Stateless
@LocalBean
public class ShuttleDAO {
	
	@PersistenceContext
    private EntityManager em;
	
	public List<Shuttle> getAllShuttles() {
		Query query=em.createQuery("SELECT s FROM Shuttle s");
        return query.getResultList();
	}
}
