package com.nhom13.service.impl;

import java.util.List;

import com.nhom13.dto.BookDTO;
import com.nhom13.payload.response.DataResponse;

public interface IBookService {
	
	public List<BookDTO> getListBook();
	public BookDTO getBookByID(Long id);
	public DataResponse<?> insert(BookDTO request);
	
}
