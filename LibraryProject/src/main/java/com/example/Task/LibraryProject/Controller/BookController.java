package com.example.Task.LibraryProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task.LibraryProject.Entity.Book;
import com.example.Task.LibraryProject.Service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
	    bookService.addBook(book);
	    return "Book inserted successfully";
	}
	
	@GetMapping("/getAllBook")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
	
	@GetMapping("/get/{id}")
	public Book getBookById(@PathVariable int id) {
	    return bookService.getBookById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
	    Book book = bookService.deleteBookById(id);
	    if (book != null) {
	    	return "Book iD " + id + " deleted successfully.";
	    } else {
	        return "Not available: " + id;
	    }
	}

	@PatchMapping("/{id}/availability")
	public Book updateAvailability(@PathVariable int id, @RequestParam boolean available) {
	    return bookService.updateAvailable(id, available);
	}

}
