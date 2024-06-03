package com.ibm.twitter.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.twitter.entity.ChatMessage;
import com.ibm.twitter.entity.Message;
import com.ibm.twitter.repo.ChatRepo;
import com.ibm.twitter.repo.MessageRepo;

@Service
public class ChatServiceImpl {
	@Autowired
    ChatRepo chatrepo;
    
   

    
    public ChatMessage findById(int id) {
        return chatrepo.findById((long) id).orElse(null);
    }

    
    public void save(ChatMessage message) {
        chatrepo.save(message);
    }

    
    public void put(ChatMessage message) {
        chatrepo.save(message);
    }

    public void deleteById(int id) {
        chatrepo.deleteById((long) id);
    }
}