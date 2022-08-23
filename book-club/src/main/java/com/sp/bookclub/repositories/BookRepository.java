package com.sp.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sp.bookclub.models.Books;

public interface BookRepository extends CrudRepository< Books, Long>{
	List<Books> findAll(); 

}
