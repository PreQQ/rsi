/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rest1;

/**
 *
 * @author michal
 */

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("/comments")
public class CommentResource {
    
    // comments przypisane do messageId
    private static Map<Long, List<String>> commentsData = new HashMap<>();

    @GET
    public Response getComments(@PathParam("messageId") long messageId) {
        List<String> comments = commentsData.getOrDefault(messageId, new ArrayList<>());
        return Response.ok(comments).build();
    }

    @POST
    public Response addComment(@PathParam("messageId") long messageId, String comment) {
        commentsData.computeIfAbsent(messageId, k -> new ArrayList<>()).add(comment);
        return Response.status(Response.Status.CREATED).build();
    }
}
