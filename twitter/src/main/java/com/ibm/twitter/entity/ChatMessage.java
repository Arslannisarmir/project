package com.ibm.twitter.entity;

import java.awt.TrayIcon.MessageType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="chat")
public class ChatMessage {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String content;
    private String sender;
    private MessageType type;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "ChatMessage [id=" + id + ", content=" + content + ", sender=" + sender + ", type=" + type + "]";
	}
	
	public ChatMessage(int id, String content, String sender, MessageType type) {
		super();
		this.id = id;
		this.content = content;
		this.sender = sender;
		this.type = type;
	}
	public ChatMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
    

}
