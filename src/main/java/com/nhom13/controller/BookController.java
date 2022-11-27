package com.nhom13.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/book/{id}")
	public ResponseEntity<?> getBookByID(@PathVariable long id){
		return ResponseEntity.ok(bookService.getBookByID(id));
	}
	
	@PostMapping("/admin/insert_book")
	public ResponseEntity<?> insert(@RequestParam String name, @RequestParam String authorname,
			@RequestParam Long price, @RequestParam String description, @RequestParam Long id_category, @RequestParam MultipartFile img) throws IOException{
		BookDTO request = new BookDTO();
		request.setAuthorname(authorname);
		request.setDescription(description);
		request.setId_category(id_category);
		request.setName(name);
		request.setPrice(price);
		return ResponseEntity.ok(bookService.insert(request, img));
	}
	
	@PutMapping("/admin/update_book/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestParam String name, @RequestParam String authorname, @RequestParam Long price, 
			@RequestParam String description, @RequestParam Long id_category, @RequestParam(required = false) MultipartFile img) throws IOException{
		BookDTO request = new BookDTO();
		request.setAuthorname(authorname);
		request.setDescription(description);
		request.setId_category(id_category);
		request.setName(name);
		request.setPrice(price);
		return ResponseEntity.ok(bookService.update(request, id, img));
	}

}
