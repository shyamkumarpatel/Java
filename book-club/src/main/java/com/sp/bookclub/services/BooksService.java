package com.sp.bookclub.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.bookclub.models.Books;
import com.sp.bookclub.repositories.BookRepository;

@Service
public class BooksService {
	@Autowired
    private BookRepository bookRepo;
	
	//create
    public Books createBooks(Books books) {
    	return bookRepo.save(books);
    }
    
	//find all
	public List<Books> findAllBooks(){
    	return bookRepo.findAll();
    }
	
	//find one
    public Books findBook(Long id) {
    	Optional<Books> optionalBooks = bookRepo.findById(id);
    	if(optionalBooks.isPresent()) {
    		return optionalBooks.get();
    	}else {
    		return null;
    	}
    }
	
	//update
    public Books updateBook(Books books) {
    	return bookRepo.save(books);
    }
    
	//delete
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
    
}
