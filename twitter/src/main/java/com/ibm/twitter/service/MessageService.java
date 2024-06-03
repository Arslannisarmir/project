package com.ibm.twitter.service;

import com.ibm.twitter.entity.Message;
import java.util.List;

public interface MessageService {
    
    Message findById(int id);
    
    List<Message> findByUserId(int userId); // New method to find messages by user ID
    
    void save(Message message);
    
    void put(Message message);
    void deleteById(int id);

}
