package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;
import com.nhom13.repository.BookRepository;
import com.nhom13.service.impl.IBookService;

@Service
@Component
public class BookService implements IBookService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	BookRepository bookRepo;

	@Override
	public List<BookDTO> getListBook() {
		List<Book> books = bookRepo.findAll();
		List<BookDTO> listBooks = new ArrayList<>(); 
		for(Book book : books){
			BookDTO bookDTO = new BookDTO();
			modelMapper.map(book, BookDTO.class);
			listBooks.add(bookDTO);
		}
		return listBooks;
	}

	@Override
	public BookDTO getBookByID(Long id) {
		Book findBook = bookRepo.findById(id).orElseThrow();
		BookDTO bookDTO = modelMapper.map(findBook, BookDTO.class);
		return bookDTO;
	}
	
}
