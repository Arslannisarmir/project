package com.ibm.twitter.service;

import java.util.List;

import com.ibm.twitter.entity.ChatMessage;

public interface ChatService {
	 ChatMessage findById(int id);
	    
	    
	    
	    void save(ChatMessage message);
	    
	    void put(ChatMessage message);
	    void deleteById(int id);

}
