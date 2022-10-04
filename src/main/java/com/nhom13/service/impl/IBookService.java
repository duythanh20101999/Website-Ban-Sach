package com.nhom13.service.impl;

import com.nhom13.dto.BookDTO;
import org.springframework.beans.factory.UnsatisfiedDependencyException;

import java.util.List;

public interface IBookService {
	
	public List<BookDTO> getListBook();
	public BookDTO getBookByID(Long id);
	
}
