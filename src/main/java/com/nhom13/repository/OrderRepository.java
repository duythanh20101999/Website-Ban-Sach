package com.nhom13.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Order;
@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	@Query(value = "SELECT * FROM orders where status = :status", nativeQuery = true)
	public List<Order> getOrdersByStatus(@Param("status") int status); 
}
