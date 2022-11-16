package com.nhom13.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhom13.payload.response.DataResponse;

@RestController
@CrossOrigin(origins = "*")
public class test {
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return ResponseEntity.ok(new DataResponse<>(true, "OK", null));
	}
}
