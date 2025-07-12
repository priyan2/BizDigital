package com.example.Task.LibraryProject.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task.LibraryProject.Entity.Book;
import com.example.Task.LibraryProject.Repository.BookRepository;
import com.example.Task.LibraryProject.Service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll(); 
	}
	
	public Book getBookById(int id) {
	    return bookRepository.findById(id).orElse(null);
	}
	
	
	public Book deleteBookById(int id) {
	    Book book = bookRepository.findById(id).orElse(null);
	    if (book != null) {
	        bookRepository.deleteById(id);
	    }
	    return book;
	}

	
	public Book updateAvailable(int id, boolean available) {
	    Book book = bookRepository.findById(id).orElse(null);
	    if (book != null) {
	        book.setAvailable(available);
	        return bookRepository.save(book);
	    }
	    return null;
	}

	 
}