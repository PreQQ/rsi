/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rest1;

/**
 *
 * @author michal
 */

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.core.Context;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.HttpHeaders;
//import javax.inject.Singleton;
import java.net.URI;

@Path("/messages")
//@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
    
    private int counter = 0;

    @GET
    @Path("/counter")
    public String getCounter() {
        counter++;
        return "Counter: " + counter;
    }
    
    @Context
    UriInfo uriInfo;

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces("application/json")
    public Response getMessage(@PathParam("messageId") Long id) {
        Message message = messageService.getMessage(id);
        
        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Tworzymy linki HATEOAS
        message.addLink(new Link("self", uriInfo.getAbsolutePath().toString())); 
        message.addLink(new Link("comments", uriInfo.getAbsolutePathBuilder().path("comments").toString()));

        return Response.ok(message).build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createMessage(Message message) {
        // Logika tworzenia message w serwisie
        Message createdMessage = messageService.createMessage(message);
        URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(createdMessage.getId())).build();

        return Response.created(location)
                       .entity(createdMessage)
                       .build();
    }
    
    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") Long messageId, Message message) {

    return messageService.updateMessage(messageId, message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public boolean deleteMessage(@PathParam("messageId") Long messageId) {
        return messageService.deleteMessage(messageId);
    }
    
    @GET
    @Path("/search")
    public Response searchMessages(@QueryParam("author") String author, @QueryParam("content") String content) {
        String result = "Searching for messages with author: " + author + " and content: " + content;
        return Response.ok(result).build();
    }
    
    @GET
    @Path("/headers")
    public Response getHeadersInfo(@HeaderParam("User-Agent") String userAgent) {
        String result = "User-Agent header value: " + userAgent;
        return Response.ok(result).build();
    }

    @GET
    @Path("/matrix/{id}")
    public Response getMatrixParams(@MatrixParam("category") String category, @MatrixParam("type") String type) {
        String result = "Category: " + category + ", Type: " + type;
        return Response.ok(result).build();
    }
    
    @GET
    @Path("/uri-info")
    public Response getUriInfo(@Context UriInfo uriInfo) {
        String uri = uriInfo.getAbsolutePath().toString();
        return Response.ok("Full URI: " + uri).build();
    }
    
    @GET
    @Path("/headers-info")
    public Response getHeadersInfo(@Context HttpHeaders headers) {
        String userAgent = headers.getHeaderString("User-Agent");
        String acceptLanguage = headers.getHeaderString("Accept-Language");

        String result = "User-Agent: " + userAgent + ", Accept-Language: " + acceptLanguage;
        return Response.ok(result).build();
    }
    
    @Path("/{messageId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public CommentResource getCommentResource() {
        return new CommentResource();
    }
}
