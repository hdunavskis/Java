package com.ait.racing;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class RaceHorse {

	@Id
	private int id;
	private String name;
	private String trainer;
	private String jockey;
	private String owner;
	private String breeder;
	private String sire;
	private String dam;
	private String picture;
	private int age;
	private String betting;
	
	public RaceHorse() {}
	
	public RaceHorse(int id, String name, String trainer, String jockey, String owner, String breeder, String sire,
			String dam, String picture, int age, String betting) {
		super();
		this.id = id;
		this.name = name;
		this.trainer = trainer;
		this.jockey = jockey;
		this.owner = owner;
		this.breeder = breeder;
		this.sire = sire;
		this.dam = dam;
		this.picture = picture;
		this.age = age;
		this.betting = betting;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public String getJockey() {
		return jockey;
	}
	public void setJockey(String jockey) {
		this.jockey = jockey;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getBreeder() {
		return breeder;
	}
	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}
	public String getSire() {
		return sire;
	}
	public void setSire(String sire) {
		this.sire = sire;
	}
	public String getDam() {
		return dam;
	}
	public void setDam(String dam) {
		this.dam = dam;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBetting() {
		return betting;
	}
	public void setBetting(String betting) {
		this.betting = betting;
	}
	
	
}
