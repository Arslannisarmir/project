package com.ibm.twitter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tweet")
public class Tweet {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="text")
	String text;
	
	@Column(name="user_id")
	int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Tweet(int id, String text, int userId) {
		super();
		this.id = id;
		this.text = text;
		this.userId = userId;
	}
	public Tweet(String text, int userId) {
		super();
		this.text = text;
		this.userId = userId;
	}

	public Tweet() {
		super();
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", text=" + text + ", userId=" + userId + "]";
	}
	
	
	
}
