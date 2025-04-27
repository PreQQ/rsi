/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rest1;

/**
 *
 * @author michal
 */
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class MessageService {
    private final static Map<Long, Message> messages = new HashMap<>();

    static {
        messages.put(1L, new Message(1L, "Hello World", "Author1"));
        messages.put(2L, new Message(2L, "Hello Again", "Author2"));
        messages.put(3L, new Message(3L, "Good Morning", "Author3"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(Long id) {
        return messages.get(id);
    }
    
    public Message createMessage(Message message) {
        message.setId(messages.size() + 1L);
        messages.put(messages.size() + 1L, message);
        return message;
    }
    
    public Message updateMessage(Long id, Message message) {
        if (messages.containsKey(id)) {
            Message existingMessage = messages.get(id);
            existingMessage.setMessage(message.getMessage());
            existingMessage.setAuthor(message.getAuthor());
            return existingMessage;
        }
        
        return null;
    }
    
    public boolean deleteMessage(Long id) {
        if (messages.containsKey(id)) {
            messages.remove(id);
            return true;
        }
        return false;
    }
}

