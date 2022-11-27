package com.nhom13.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nhom13.dto.BookDTO;
import com.nhom13.payload.response.BookResponse;
import com.nhom13.payload.response.DataResponse;

public interface IBookService {
	
	public DataResponse<BookResponse> getListBook();
	public DataResponse<BookResponse> getBookByID(Long id);
	public DataResponse<?> insert(BookDTO request, MultipartFile image) throws IOException;
	public DataResponse<?> update(BookDTO request, Long id, MultipartFile image) throws IOException;
}
