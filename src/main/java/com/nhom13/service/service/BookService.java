package com.nhom13.service.service;

import com.nhom13.dto.BaseDTO;
import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;

import java.util.List;

public interface BookService {
	public List<BookDTO> getListBook();
	public BookDTO getBookByID(Long id);
	
}
