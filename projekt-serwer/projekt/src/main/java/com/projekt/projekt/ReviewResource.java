/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projekt.projekt;

/**
 *
 * @author michal
 */
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


@Path("/")
public class ReviewResource {
    private final static Map<Long, List<Review>> bookReviews = new HashMap<>();

    @GET
    @Produces("application/json")
    public List<Review> getReviews(@PathParam("bookId") Long bookId) {
        return bookReviews.getOrDefault(bookId, new ArrayList<>());
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addReview(@PathParam("bookId") Long bookId, Review review) {
        List<Review> reviews = bookReviews.computeIfAbsent(bookId, k -> new ArrayList<>());
        review.setId((long) (reviews.size() + 1));
        reviews.add(review);

        return Response.status(Response.Status.CREATED).entity(review).build();
    }
}

