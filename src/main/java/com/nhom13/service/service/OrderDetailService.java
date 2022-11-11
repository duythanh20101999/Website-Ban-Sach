package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.nhom13.dto.BookDTO;
import com.nhom13.dto.OrderDetailDTO;
import com.nhom13.model.Book;
import com.nhom13.model.OrderDetail;
import com.nhom13.repository.OrderDetailRepository;
import com.nhom13.service.impl.IOrderDetailService;

public class OrderDetailService implements IOrderDetailService{
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	OrderDetailRepository orderDetailRepo;

	@Override
	public List<OrderDetailDTO> addCartByUserIdAndProductId(long id_book, long id_user, long qty, long total) throws Exception {
		//List<OrderDetail> list = orderDetailRepo.getCartByUserId(id_user);
		try {
			if(orderDetailRepo.getCartByproductIdAndUserId(id_book, id_user).isPresent()) {
				throw new Exception("SP đã tòn tại.");
			}
			OrderDetailDTO obj = new OrderDetailDTO();
			obj.setId_book(id_book);
			obj.setQuantity(qty);
			obj.setTotal(total);
			orderDetailRepo.save(obj);
			return this.getCartByUserId(id_user);
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<OrderDetailDTO> getCartByUserId(long id_user) {
//		List<OrderDetail> order = orderDetailRepo.findAll();
//		List<OrderDetailDTO> listOrd = new ArrayList<>(); 
//		for(OrderDetail orderDetail : order){
//			
//			listOrd.add(modelMapper.map(orderDetail, OrderDetailDTO.class));
//		}
		return this.getCartByUserId(id_user);
	}

	@Override
	public List<OrderDetailDTO> removeCartByUserId(long id_cart, long id_user) {
		orderDetailRepo.deleteCartByCartIdAndUserId(id_cart, id_user);
		return this.getCartByUserId(id_user);
	}

}
