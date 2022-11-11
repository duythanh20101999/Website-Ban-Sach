package com.nhom13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.repository.OrderDetailRepository;
import com.nhom13.service.impl.IOrderDetailService;

@RestController
@Controller
@RequestMapping(value = "/api")
public class OrderController {
//	@Autowired
//	private IOrderDetailService orderService;
//	@Autowired
//	private OrderDetailRepository orderRepository;
}
