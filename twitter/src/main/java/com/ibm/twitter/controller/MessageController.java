package com.ibm.twitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.twitter.entity.Message;
import com.ibm.twitter.service.MessageService; // Import the MessageService interface

@RestController
@CrossOrigin("*")
public class MessageController {
    
    @Autowired
    MessageService messageService;
    
    @PostMapping("/message")
    public ResponseEntity<?> saveMessage(@RequestBody Message message) {
        try {
        	System.out.println(message.getRecipientId());
            messageService.save(message);
            return ResponseEntity.ok("Message saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save message: " + e.getMessage());
        }
    }

    @GetMapping("/message/{userId}")
    public ResponseEntity<List<Message>> findByUserId(@PathVariable int userId) {
        List<Message> messages = messageService.findByUserId(userId);
        return ResponseEntity.ok(messages);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        try {
            messageService.deleteById(id);
            return ResponseEntity.ok("Message deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete message: " + e.getMessage());
        }
    }
}
