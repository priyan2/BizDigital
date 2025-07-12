package com.example.Task.LibraryProject.Service;

import java.util.List;

import com.example.Task.LibraryProject.Entity.Book;

public interface BookService {
	public Book addBook(Book book);
    public List<Book> getAllBooks();
    public Book deleteBookById(int id);
    public Book getBookById(int id);
    public Book updateAvailable(int id, boolean available);
}
