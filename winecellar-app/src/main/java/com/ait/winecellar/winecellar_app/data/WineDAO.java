package com.ait.winecellar.winecellar_app.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ait.winecellar.winecellar_app.model.Wine;



@Stateless
@LocalBean
public class WineDAO {

    @PersistenceContext
    private EntityManager em;
    
	public List<Wine> getAllWines() {
    	Query query=em.createQuery("SELECT w FROM Wine w");
        return query.getResultList();
    }

	public Wine getWineById(int id) {
		return em.find(Wine.class, id);
	}

	public void saveWine(Wine wine) {
		em.persist(wine);
	}

	public void updateWine(Wine wine) {
		em.merge(wine);
		
	}

	public void removeWine(int id) {
		em.remove(getWineById(id));
		
	}

	public List<Wine> getByCountry(String country) {
		Query query = em.createQuery("Select w from Wine w where w.country like? 1");
		query.setParameter(1,"%"+ country.toUpperCase() + "%");
		return query.getResultList();
	}
      
}
