package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.repository.BookRepository;
import com.nhom13.service.impl.IBookService;

import antlr.TokenWithIndex;

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
			
			listBooks.add(modelMapper.map(book, BookDTO.class));
		}
		return listBooks;
	}

	@Override
	public BookDTO getBookByID(Long id) {
		Book findBook = bookRepo.findById(id).orElseThrow();
		BookDTO bookDTO = modelMapper.map(findBook, BookDTO.class);
		return bookDTO;
	}

	@Override
	public DataResponse<?> insert(BookDTO request) {
		DataResponse<?> response = new DataResponse<>();
		
		return null;
	}
	
}
