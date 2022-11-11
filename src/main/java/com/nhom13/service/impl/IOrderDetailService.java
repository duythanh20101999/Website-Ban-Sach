package com.nhom13.service.impl;

import java.util.Collection;
import java.util.List;

import com.nhom13.model.OrderDetail;
import com.nhom13.dto.OrderDetailDTO;
import com.nhom13.model.Order;

public interface IOrderDetailService {
	List<OrderDetailDTO> addCartByUserIdAndProductId(long id_book, long id_user, long qty, long total) throws Exception;
	List<OrderDetailDTO> getCartByUserId(long id_user);
	List<OrderDetailDTO> removeCartByUserId(long id_order, long id_user);
	//CheckOutCart();
	
}
