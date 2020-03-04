package com.spaceprogram.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.spaceprogram.model.Mission;

@Stateless
@LocalBean
public class MissionDAO {

	@PersistenceContext
    private EntityManager em;
	
	public List<Mission> getAllMissions() {
		
		Query query=em.createQuery("SELECT m FROM Mission m");
        return query.getResultList();
	}
	public Mission getMissionById(int id) {
		return em.find(Mission.class, id);
	}
	public List<Mission> getMissionForAShuttle(String shuttle) {
		
		Query query=em.createQuery("SELECT m FROM Mission m where m.orbitor= ?1");
		
		query.setParameter(1, shuttle);
		return query.getResultList();
	}

}
