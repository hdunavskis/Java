package com.spaceprogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shuttlemissions")
public class Mission {
	
	@Id
	private int id;
	private String orbitor;
	private String name;
	private String launch;
	private String landing;
	private String notes;
	@Column(name="landing_site")
	private String landingSite;
	private String duration;
	
	public Mission() {}
	public Mission(int id, String orbitor, String name, String launch, String notes, String landingSite,
			String duration, String landing) {
		super();
		this.id = id;
		this.orbitor = orbitor;
		this.name = name;
		this.launch = launch;
		this.notes = notes;
		this.landingSite = landingSite;
		this.duration = duration;
		this.landing = landing;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrbitor() {
		return orbitor;
	}
	public void setOrbitor(String orbitor) {
		this.orbitor = orbitor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLaunch() {
		return launch;
	}
	public void setLaunch(String launch) {
		this.launch = launch;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getLanding_site() {
		return landingSite;
	}
	public void setLanding_site(String landing_site) {
		this.landingSite = landing_site;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLanding() {
		return landing;
	}
	public void setLanding(String landing) {
		this.landing = landing;
	}
	
	
}
