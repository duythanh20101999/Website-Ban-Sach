package com.nhom13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;
import com.nhom13.repository.BookRepository;
import com.nhom13.service.impl.IBookService;

@RestController
@Controller
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class BookController {
	@Autowired
	private IBookService bookService;
	@Autowired
	private BookRepository bookRepo;
	
	@GetMapping("/book")
	public ResponseEntity<?> getListBook(){
		
		return ResponseEntity.ok(bookService.getListBook());
	}
//	public List<Book> findALl(){
//		return this.bookRepo.findAll();
//	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBookByID(@PathVariable long id){
		BookDTO result = bookService.getBookByID(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/admin/insert_book")
	public ResponseEntity<?> insert(@RequestBody BookDTO request){
		return ResponseEntity.ok(bookService.insert(request));
	}
	
	@PutMapping("/admin/update_book/{id}")
	public ResponseEntity<?> update(@RequestBody BookDTO request,@PathVariable Long id){
		return ResponseEntity.ok(bookService.update(request, id));
	}

}
