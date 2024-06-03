package com.ibm.twitter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.twitter.entity.Message;
import com.ibm.twitter.repo.MessageRepo;
import com.ibm.twitter.service.MessageService; // Import the MessageService interface

@Service
public class MessageServiceImpl implements MessageService { // Implement the MessageService interface

    @Autowired
    MessageRepo messagerepo;
    
    @Override
    public List<Message> findByUserId(int id) {
        return messagerepo.findByUserId(id);
    }

    @Override
    public Message findById(int id) {
        return messagerepo.findById(id).orElse(null);
    }

    @Override
    public void save(Message message) {
        messagerepo.save(message);
    }

    @Override
    public void put(Message message) {
        messagerepo.save(message);
    }

    @Override
    public void deleteById(int id) {
        messagerepo.deleteById(id);
    }
}
