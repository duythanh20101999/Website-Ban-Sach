package com.nhom13.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.nhom13.dto.BookDTO;

@Repository
@EnableJpaRepositories
public interface BookRepo extends JpaRepository<BookDTO, Long> {
	
	List<BookDTO> findByID(Set<Long> id);

}
