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
	
	@SuppressWarnings("unchecked")
	public List<Mission> getAllMissions() {
		
		return em.createQuery("SELECT m FROM Mission m")
				.getResultList();
	}
	public Mission getMissionById(int id) {
		return em.find(Mission.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Mission> getMissionForAShuttle(String shuttle) {
		
		return em.createQuery("SELECT m FROM Mission m where m.orbitor= :shuttle")
				.setParameter("shuttle", shuttle)
				.getResultList();
	}
}
