package com.ibm.twitter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Post")
public class Post {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="captions")
	String captions;
	
	@Column(name="title")
	String title;
	
	@Column(name="posted_by")
	String postedBy;
	
	@Column(name="image")
	String image;
	
	@Column(name="user_id")
	int userId;
	
	
	
	

	@Override
	public String toString() {
		return "Post [id=" + id + ", captions=" + captions + ", title=" + title + ", postedBy=" + postedBy + ", image="
				+ image + ", userId=" + userId + "]";
	}

	public Post() {
		super();
	}

	public Post(int id, String captions, String title, String postedBy, String image, int userId) {
		super();
		this.id = id;
		this.captions = captions;
		this.title = title;
		this.postedBy = postedBy;
		this.image = image;
		this.userId = userId;
	}
	public Post( String captions, String title, String postedBy,int userId) {
		super();
		this.captions = captions;
		this.title = title;
		this.postedBy = postedBy;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCaptions() {
		return captions;
	}

	public void setCaptions(String captions) {
		this.captions = captions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	

}
