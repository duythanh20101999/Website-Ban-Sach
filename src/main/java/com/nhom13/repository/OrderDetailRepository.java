package com.nhom13.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Order;
import com.nhom13.model.OrderDetail;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	
	@Query(value = "SELECT addCart FROM order_detail addCart WHERE addCart.id_user= :id_user", nativeQuery = true)
	public  List<OrderDetail> getCartByUserId(@Param("id_user") long id_user);
	
	@Query(value = "SELECT addCart FROM order_detail addCart WHERE addCart.id_book= :id_book and addCart.id_user= :id_user", nativeQuery = true)
	public  Optional<OrderDetail> getCartByproductIdAndUserId(@Param("id_book") long id_book, @Param("id_user") long id_user);
	
	@Modifying
	@Query(value = "DELETE FROM order_detail addCart WHERE addCart.id_cart= :id_cart and addCart.id_user= :id_user", nativeQuery = true)
	public OrderDetail deleteCartByCartIdAndUserId(@Param("id_cart")long id_cart, @Param("id_user") long id_user);
	
	@Modifying	
	@Query(value = "DELETE FROM order_detail addCart WHERE addCart.id_user=:id_user", nativeQuery = true)
	void deleteAllUserId(@Param("id_user")long id_user);

	@Modifying	
	@Query(value = "UPDATE order_detail addCart set addCart.quantity= :quantity, addCart.total= :total WHERE addCart.id_order=:id_order", nativeQuery = true)
	void updateQtyByCartId(@Param("id_cart")long id_cart, @Param("total")long total, @Param("quantity")long quantity);

}
