package com.ait.winecellar.winecellar_app.util;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class UtilsDAO {

    @PersistenceContext
    private EntityManager em;
    
	public void deleteTable(){
		em.createQuery("DELETE FROM Wine").executeUpdate();
		em.createNativeQuery("ALTER TABLE Wine AUTO_INCREMENT=1")
		.executeUpdate();
		
	}
      
}
