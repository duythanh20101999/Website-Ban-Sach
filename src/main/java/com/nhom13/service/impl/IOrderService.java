package com.nhom13.service.impl;

import com.nhom13.payload.response.DataResponse;
import com.nhom13.payload.response.OrderResponse;

public interface IOrderService {
	DataResponse<OrderResponse> getAllOrders();
	DataResponse<OrderResponse> getOrderById(Long id);

}
