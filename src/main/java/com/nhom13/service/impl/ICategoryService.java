package com.nhom13.service.impl;

import com.nhom13.dto.CategoryDTO;
import com.nhom13.payload.response.DataResponse;

public interface ICategoryService {

	DataResponse<CategoryDTO> getAllCategories();
	DataResponse<CategoryDTO> getCategoryById(Long id);
	DataResponse<?> insert(CategoryDTO category);
	DataResponse<?> update(CategoryDTO category, Long id);
}
