package com.nhom13.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Book;

@Repository

public interface BookRepository extends JpaRepository<Book, Long> {
	
//	List<Book> findByID(Long id);

}
