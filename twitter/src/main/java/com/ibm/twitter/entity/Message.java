package com.ibm.twitter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Message")
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    
    @Column(name="text")
    String text;
    
    @Column(name="user_id")
    int userId;
    
    @Column(name="recipient_id") // New field for recipient's user ID
    int recipientId; // New field for recipient's user ID

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

    public int getRecipientId() { // Getter for recipient's user ID
        return recipientId;
    }

    public void setRecipientId(int recipientId) { // Setter for recipient's user ID
        this.recipientId = recipientId;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", text=" + text + ", userId=" + userId + ", recipientId=" + recipientId + "]";
    }

    public Message(int id, String text, int userId, int recipientId) {
        super();
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.recipientId = recipientId;
    }

    public Message(String text, int userId, int recipientId) {
        super();
        this.text = text;
        this.userId = userId;
        this.recipientId = recipientId;
    }

    public Message() {
        super();
    }
}
