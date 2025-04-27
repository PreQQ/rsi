/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projekt.projekt;

/**
 *
 * @author michal
 */

import java.util.Date;

public class Review {
    private Long id;
    private String reviewer;
    private String content;
    private Date created;
    
    public Review(Long id, String reviewer, String content, Date created) {
        this.id = id;
        this.reviewer = reviewer;
        this.content = content;
        this.created = created;
    }
    
    public Review() {}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

