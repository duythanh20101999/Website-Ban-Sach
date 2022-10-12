package com.nhom13.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Category;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "SELECT * FROM category where name = :name", nativeQuery = true)
	public List<Category> getCategoryByName(@Param("name") String name);
}
