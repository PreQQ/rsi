/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rest1;

/**
 *
 * @author michal
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
    private Long id;
    private String message;
    private String author;

    public Message() {}

    public Message(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}