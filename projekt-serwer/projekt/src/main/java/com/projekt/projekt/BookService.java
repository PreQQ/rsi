/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projekt.projekt;

/**
 *
 * @author michal
 */

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class BookService {
    private Map<Long, Book> books = new HashMap<>();

    public BookService() {
        books.put(1L, new Book(1L, "Effective Java", "Joshua Bloch", new Date()));
    }

    public List<Book> getAllBooks() { return new ArrayList<>(books.values()); }
    
    public Book getBook(Long id) { return books.get(id); }
    
    public Book addBook(Book book) {
        book.setId((long) (books.size() + 1));
        books.put(book.getId(), book);

        return book;
    }
    
    public Book updateBook(Long id, Book updatedBook) {
        if (books.containsKey(id)) {
            Book existingBook = books.get(id);

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setCreated(updatedBook.getCreated());
            existingBook.setReviews(updatedBook.getReviews());
            existingBook.setLinks(updatedBook.getLinks());

            return existingBook;
        }
        return null;
    }
    
    public void removeBook(Long id) { books.remove(id); }
}

