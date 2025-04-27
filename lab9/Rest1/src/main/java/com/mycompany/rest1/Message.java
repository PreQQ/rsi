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
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Message {
    private Long id;
    private String message;
    private String author;
    
    private List<Link> links = new ArrayList<>();

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
    
    public List<Link> getLinks() { return links; }
    public void setLinks(List<Link> links) { this.links = links; }
    public void addLink(Link link) { this.links.add(link); }
}