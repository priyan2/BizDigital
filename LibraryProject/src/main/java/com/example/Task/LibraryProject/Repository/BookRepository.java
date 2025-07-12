package com.example.Task.LibraryProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Task.LibraryProject.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
	
}
