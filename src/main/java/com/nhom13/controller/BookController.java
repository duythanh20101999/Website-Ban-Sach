package com.nhom13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.dto.BookDTO;
import com.nhom13.service.impl.IBookService;

@RestController
@Controller
@RequestMapping(value = "/api")
public class BookController {
	@Autowired
	private IBookService bookService;
	@GetMapping("/book")
	public ResponseEntity<?> getListBook(){
		List<BookDTO> books = bookService.getListBook();
		return ResponseEntity.ok(books);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBookByID(@PathVariable long id){
		BookDTO result = bookService.getBookByID(id);
		return ResponseEntity.ok(result);
	}
	

}
