package com.spaceprogram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="shuttles")
public class Shuttle {

	@Id
	private int id;
	private String name;
	@Column(name = "image_thumb")
	private String imageThumb;
	@Column(name ="image_caption")
	private String imageCaption;
	private String description;
	
	public Shuttle() {}
	
	public Shuttle(int id, String name, String imageThumb, String imageCaption, String description) {
		super();
		this.id = id;
		this.name = name;
		this.imageThumb = imageThumb;
		this.imageCaption = imageCaption;
		this.description = description;
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
	public String getImage_thumb() {
		return imageThumb;
	}
	public void setImage_thumb(String image_thumb) {
		this.imageThumb = image_thumb;
	}
	public String getImage_caption() {
		return imageCaption;
	}
	public void setImage_caption(String image_caption) {
		this.imageCaption = image_caption;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
