package com.ait.racing;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class RaceDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<RaceHorse> getAllHorses() {
		return em.createQuery("Select h From RaceHorse h")
				.getResultList();
	}

	public RaceHorse getById(int id) {
		return em.find(RaceHorse.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<RaceHorse> getByName(String name) {
		return em.createQuery("SELECT h FROM RaceHorse h WHERE h.name LIKE :name")
				.setParameter("name", "%"+name+"%")
				.getResultList();
	}

}
