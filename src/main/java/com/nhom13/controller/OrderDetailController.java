//package com.nhom13.controller;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.nhom13.config.ShoppingConfig;
//import com.nhom13.dto.OrderDetailDTO;
//import com.nhom13.repository.OrderDetailRepository;
//import com.nhom13.service.impl.IOrderDetailService;
//import com.nhom13.service.service.OrderDetailService;
//
//@RestController
//@Controller
//@RequestMapping(value = "/api")
//public class OrderDetailController {
//	
//	@Autowired
//	private OrderDetailService orderDetailService;
//	
//	@RequestMapping("/addBook")
//	public ResponseEntity<?> addCartWithBook(@RequestBody HashMap<String, String> addCartRequest){
//		//addCartRequest.get("");
//		try {
//			String keys[] = {"ib_book","id_user","quantity","total"};
//			if(ShoppingConfig.validationWithHashMap(keys, addCartRequest)) {
//				
//			}
//			long id_book = Long.parseLong(addCartRequest.get("id_book"));
//			long id_user = Long.parseLong(addCartRequest.get("id_user"));
//			long quantity = Long.parseLong(addCartRequest.get("quantity"));
//			long total = Long.parseLong(addCartRequest.get("total"));
//			List<OrderDetailDTO> obj = orderDetailService.addCartByUserIdAndProductId(id_book, id_user, quantity, total);
//			return ResponseEntity.ok(obj);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
////			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),""));
//			return null;
//		}
//	}
//	
//	@RequestMapping("/updateQuantity")
//	public ResponseEntity<?> updateQuantity(@RequestBody HashMap<String, String> addCartRequest){
//		//addCartRequest.get("");
//		try {
//			String keys[] = {"ib_cart","id_user","quantity","total"};
//			if(ShoppingConfig.validationWithHashMap(keys, addCartRequest)) {
//				
//			}
//			long id_book = Long.parseLong(addCartRequest.get("id_book"));
//			long id_user = Long.parseLong(addCartRequest.get("id_user"));
//			long quantity = Long.parseLong(addCartRequest.get("quantity"));
//			long total = Long.parseLong(addCartRequest.get("total"));
//			orderDetailService.updateQtyByCartId(id_book, quantity, total);
//			List<OrderDetailDTO> obj = orderDetailService.getCartByUserId(id_user);
//			return ResponseEntity.ok(obj);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
////			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),""));
//			return null;
//		}
//	}
//	
//	@RequestMapping("/removeBookFromCart")
//	public ResponseEntity<?> removeCartWithIdBook(@RequestBody HashMap<String, String> removeCartRequest){
//		try {
//			String keys[] = {"id_cart","id_user"};
//			if(ShoppingConfig.validationWithHashMap(keys, removeCartRequest)) {
//				
//			}
//			List<OrderDetailDTO> obj = orderDetailService.removeCartByUserId(Long.parseLong("id_cart"), Long.parseLong("id_user"));
//			return ResponseEntity.ok(obj);
//		}catch (Exception e) {
////			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),""));
//		}
//		return null;
//	}
//	
//	@RequestMapping("/getCartByUserId")
//	public ResponseEntity<?> getCartByUserId(@RequestBody HashMap<String, String> getCartRequest){
//		try {
//			String keys[] = {"id_user"};
//			if(ShoppingConfig.validationWithHashMap(keys, getCartRequest)) {
//				
//			}
//			List<OrderDetailDTO> obj = orderDetailService.getCartByUserId(Long.parseLong("id_user"));
//			return ResponseEntity.ok(obj);
//		}catch (Exception e) {
////			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),""));
//			return null;
//		}
//	}
//}
