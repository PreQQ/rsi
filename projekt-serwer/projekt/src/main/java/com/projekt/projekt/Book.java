/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projekt.projekt;

/**
 *
 * @author michal
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Book {
    private Long id;
    private String title;
    private String author;
    private Date created;
    private List<Review> reviews = new ArrayList<>();
    private List<Link> links; 
    
    public Book(Long id, String title, String author, Date created) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.created = created;
    }
    
    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    
    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
}

