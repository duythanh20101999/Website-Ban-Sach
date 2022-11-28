package com.nhom13.service.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhom13.dto.BookDTO;
import com.nhom13.dto.OrderDTO;
import com.nhom13.model.Book;
import com.nhom13.model.Order;
import com.nhom13.model.OrderDetail;
import com.nhom13.payload.response.BookResponse;
import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.OrderResponse;
import com.nhom13.repository.OrderRepository;
import com.nhom13.service.impl.IOrderService;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	OrderRepository repository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public DataResponse<OrderResponse> getAllOrders() {
		DataResponse<OrderResponse> response = new DataResponse<>();
		List<Order> orders = repository.findAll();
		if(orders != null) {
			List<OrderResponse> listOrder = new ArrayList<>();
			for(Order order : orders) {
				OrderResponse orderResponse = new OrderResponse();
				orderResponse.setAddress(order.getAddress());
				orderResponse.setName(order.getName());
				orderResponse.setPhone(order.getPhone());
				orderResponse.setUsername(order.getUser().getUsername());
				orderResponse.setDate(order.getDate());
				if(order.getStatus() == 0) {
					orderResponse.setStatus("Chưa thanh toán");
				}else if(order.getStatus() == 1){
					orderResponse.setStatus("Đã thanh toán");
				}else {
					orderResponse.setStatus("Chưa xác nhận");
				}
				orderResponse.setTotal_price(order.getTotalPrice());
				orderResponse.setId(order.getId());
				
				List<OrderDetail> orDetails = order.getOrderDetails();
				List<BookResponse> listBook = new ArrayList<>();
				for(OrderDetail orderDetail: orDetails) {
					BookResponse book = modelMapper.map(orderDetail.getBook(), BookResponse.class);
					listBook.add(book);
				}
				orderResponse.setBooks(listBook);
				listOrder.add(orderResponse);
			}
			response.setSuccess(true);
			response.setMessage("Success");
			response.setDatas(listOrder);
			
		}else {
			response.setSuccess(false);
			response.setMessage("Order is empty");
		}
		return response;
	}

	@Override
	public DataResponse<OrderResponse> getOrderById(Long id) {
		DataResponse<OrderResponse> response = new DataResponse<>();
		Order order = repository.getById(id);
		if(order != null) {
			OrderResponse orderResponse = new OrderResponse();
			orderResponse.setAddress(order.getAddress());
			orderResponse.setName(order.getName());
			orderResponse.setPhone(order.getPhone());
			orderResponse.setUsername(order.getUser().getUsername());
			orderResponse.setDate(order.getDate());
			if(order.getStatus() == 0) {
				orderResponse.setStatus("Chưa thanh toán");
			}else {
				orderResponse.setStatus("Đã thanh toán");
			}
			orderResponse.setTotal_price(order.getTotalPrice());
			orderResponse.setId(order.getId());
			List<OrderDetail> orDetails = order.getOrderDetails();
			List<BookResponse> listBook = new ArrayList<>();
			for(OrderDetail orderDetail: orDetails) {
				BookResponse book = modelMapper.map(orderDetail.getBook(), BookResponse.class);
				book.setQuantity(orderDetail.getQuantity());
				listBook.add(book);
			}
			
			orderResponse.setBooks(listBook);
			response.setSuccess(true);
			response.setMessage("Success");
			response.setData(orderResponse);
		}
		return response;
	}

	@Override
	public DataResponse<OrderResponse> getOrderByStatus(int status) {
		DataResponse<OrderResponse> response = new DataResponse<>();
		List<Order> orders = repository.getOrdersByStatus(status);
		if(orders.size()!=0) {
			List<OrderResponse> listOrder = new ArrayList<>();
			for(Order order : orders) {
				OrderResponse orderResponse = new OrderResponse();
				orderResponse.setAddress(order.getAddress());
				orderResponse.setName(order.getName());
				orderResponse.setPhone(order.getPhone());
				orderResponse.setUsername(order.getUser().getUsername());
				orderResponse.setDate(order.getDate());
				if(order.getStatus() == 0) {
					orderResponse.setStatus("Chưa thanh toán");
				}else if(order.getStatus() == 1){
					orderResponse.setStatus("Đã thanh toán");
				}else {
					orderResponse.setStatus("Chưa xác nhận");
				}
				orderResponse.setTotal_price(order.getTotalPrice());
				orderResponse.setId(order.getId());
				
				List<OrderDetail> orDetails = order.getOrderDetails();
				List<BookResponse> listBook = new ArrayList<>();
				for(OrderDetail orderDetail: orDetails) {
					BookResponse book = modelMapper.map(orderDetail.getBook(), BookResponse.class);
					listBook.add(book);
				}
				orderResponse.setBooks(listBook);
				listOrder.add(orderResponse);
			}
			response.setSuccess(true);
			response.setMessage("Success");
			response.setDatas(listOrder);
			
		}else {
			response.setSuccess(false);
			response.setMessage("Order is empty");
		}
		return response;
	}
	
}
