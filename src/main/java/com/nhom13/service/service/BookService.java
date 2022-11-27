package com.nhom13.service.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nhom13.dto.BookDTO;
import com.nhom13.model.Book;
import com.nhom13.model.Category;
import com.nhom13.payload.response.BookResponse;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.repository.BookRepository;
import com.nhom13.repository.CategoryRepository;
import com.nhom13.service.impl.IBookService;

import net.bytebuddy.utility.RandomString;

@Service
@Component
public class BookService implements IBookService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	BookRepository bookRepo;
	@Autowired
	CategoryRepository categoryRepository;
	
	private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

	@Override
	public DataResponse<BookResponse> getListBook() {
		DataResponse<BookResponse> response = new DataResponse<>();
		List<Book> books = bookRepo.findAll();
		List<BookResponse> listBooks = new ArrayList<>(); 
		for(Book book : books){
			BookResponse bookresponse = new BookResponse();
			bookresponse = modelMapper.map(book, BookResponse.class);
			listBooks.add(bookresponse);
		}
		response.setDatas(listBooks);
		response.setSuccess(true);
		response.setMessage("Success");
		return response;
	}

	@Override
	public DataResponse<BookResponse> getBookByID(Long id) {
		DataResponse<BookResponse> response = new DataResponse<>();
		Book book = bookRepo.getById(id);
		if(book == null) {
			response.setSuccess(false);
			response.setMessage("Book not found");
			return response;
		}
		BookResponse bookRes = modelMapper.map(book, BookResponse.class);
		response.setSuccess(true);
		response.setMessage("Ok");
		response.setData(bookRes);
		return response;
	}

	@Override
	public DataResponse<?> insert(BookDTO request, MultipartFile image) throws IOException{
		DataResponse<?> response = new DataResponse<>();
		Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        String code = RandomString.make(10);
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(code + image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }
		Book book = modelMapper.map(request, Book.class);
		Category category = categoryRepository.getById(request.getId_category());
		book.setCategory(category);
		book.setImage(code + image.getOriginalFilename());
		bookRepo.save(book);
		response.setSuccess(true);
		response.setMessage("Create successful product");
		return response;
	}

	@Override
	public DataResponse<?> update(BookDTO request, Long id, MultipartFile image) throws IOException {
		DataResponse<?> response = new DataResponse<>();
		Book book = bookRepo.getById(id);
		if(book == null) {
			response.setSuccess(false);
			response.setMessage("Book not found");
			return response;
		}
		String imageOld = book.getImage();
		book = modelMapper.map(request, Book.class);
		book.setCategory(categoryRepository.getById(request.getId_category()));
		book.setId(id);
		book.setImage(imageOld);
		if(image != null) {
			Path staticPath = Paths.get("static");
	        Path imagePath = Paths.get("images");
	        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
	            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
	        }
	        
	        String code = RandomString.make(10);
	        Path file = CURRENT_FOLDER.resolve(staticPath)
	                .resolve(imagePath).resolve(code + image.getOriginalFilename());
	        if(imageOld != null) {
	        	Path fileOldPath = CURRENT_FOLDER.resolve(staticPath)
		                .resolve(imagePath).resolve(imageOld);
		        if(fileOldPath!=null) {
		        	Files.delete(fileOldPath);
		        }
	        }
	        
	        try (OutputStream os = Files.newOutputStream(file)) {
	            os.write(image.getBytes());
	        }
	        book.setImage(code + image.getOriginalFilename());
		}
		
		bookRepo.save(book);
		response.setSuccess(true);
		response.setMessage("Update successfull");
		return response;
	}
	
	
}
