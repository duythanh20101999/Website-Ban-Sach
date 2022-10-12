package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom13.dto.CategoryDTO;
import com.nhom13.model.Category;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.repository.CategoryRepository;
import com.nhom13.service.impl.ICategoryService;

@Service
public class CategoryService implements ICategoryService{
	@Autowired
	CategoryRepository repository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public DataResponse<CategoryDTO> getAllCategories() {
		DataResponse<CategoryDTO> response = new DataResponse<>();
		List<Category> categories = repository.findAll();
		List<CategoryDTO> listCategory = new ArrayList<>();
		for(Category category : categories) {
			listCategory.add(modelMapper.map(category, CategoryDTO.class));
		}
		response.setSuccess(true);
		response.setDatas(listCategory);
		return response;
	}

	@Override
	public DataResponse<CategoryDTO> getCategoryById(Long id) {
		DataResponse<CategoryDTO> response = new DataResponse<>();
		Optional<Category> category = repository.findById(id);
		if(category.isEmpty()) {
			response.setSuccess(false);
			response.setMessage("Not found category with id: "+ id);
			return response;
		}
		response.setSuccess(true);
		response.setData(modelMapper.map(category, CategoryDTO.class));
		return response;
	}

	@Override
	public DataResponse<?> insert(CategoryDTO request) {
		DataResponse<?> response = new DataResponse<>();
		
		List<Category> categories = repository.getCategoryByName(request.getName());
		for(Category category : categories) {
			if(request.getName().equalsIgnoreCase(category.getName())) {
				response.setMessage("Exist category");
				response.setSuccess(false);
				return response;
			}
		}
		Category category = modelMapper.map(request, Category.class);
		repository.save(category);
		response.setSuccess(true);
		response.setMessage("Insert success");
		return response;
	}

	@Override
	public DataResponse<?> update(CategoryDTO request, Long id) {
		DataResponse<?> response = new DataResponse<>();
		List<Category> categories = repository.getCategoryByName(request.getName());
		for(Category category : categories) {
			if(request.getName().equalsIgnoreCase(category.getName())) {
				response.setMessage("Exist category");
				response.setSuccess(false);
				return response;
			}
		}
		Category category = repository.getReferenceById(id);
		category.setName(request.getName());
		repository.save(category);
		response.setSuccess(true);
		response.setMessage("Update Success");
		return response;
	}

}
