package com.nhom13.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;

import com.nhom13.dto.BaseDTO;
import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;
import com.nhom13.repository.BookRepo;
import com.nhom13.service.service.BookService;

@Component
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo bookRepo;
	
	private static ArrayList<BookDTO> books = new ArrayList<BookDTO>();

	@Override
	public List<BookDTO> getListBook() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public BookDTO getBookByID(Long id) {
		BookDTO findBook = bookRepo.findById(id).orElseThrow();
		return findBook;
	}
	
}
