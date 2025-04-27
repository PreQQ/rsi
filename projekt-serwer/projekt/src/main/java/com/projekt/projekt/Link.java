/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projekt.projekt;

/**
 *
 * @author michal
 */

public class Link {
    private String rel;
    private String href;

    // Constructor
    public Link(String rel, String href) {
        this.rel = rel;
        this.href = href;
    }

    // Getters and setters
    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
