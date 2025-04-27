/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.rest1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author michal
 */

@Path("hello")
public class HelloWorldService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getHtml() {
        return "Hello, World!";
    }

    @GET
    @Path("echo")
    @Produces(MediaType.TEXT_PLAIN)
    public String getEcho() {
        return "Witaj Echo";
    }

    @GET
    @Path("echo2/{parametr}")
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(@PathParam("parametr") String parametr) {
        return "Witaj " + parametr;
    }
}
