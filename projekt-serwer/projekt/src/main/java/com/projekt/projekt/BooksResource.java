/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.projekt.projekt;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Context;
import java.net.URI;
import java.util.List;
import java.util.Arrays;

/**
 * REST Web Service
 *
 * @author michal
 */
@Path("books")
public class BooksResource {
    @Context UriInfo uriInfo;

    private final BookService bookService = new BookService();

    @GET
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{bookId}")
    public Book getBook(@PathParam("bookId") Long bookId) {
        Book book = bookService.getBook(bookId);

        String bookUri = uriInfo.getAbsolutePathBuilder().build().toString();
        String reviewsUri = uriInfo.getAbsolutePathBuilder().path("/{bookId}/reviews").build(bookId).toString();

        List<Link> links = Arrays.asList(
    new Link("self", bookUri),
    new Link("reviews", reviewsUri)
);

        book.setLinks(links);
        return book;
    }

    @POST
    public Response addBook(Book book) {
        Book newBook = bookService.addBook(book);
        URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(newBook.getId())).build();
        return Response.created(uri).entity(newBook).build();
    }

    @Path("/{bookId}/reviews")
    public ReviewResource getReviewResource() {
        return new ReviewResource();
    }
}
