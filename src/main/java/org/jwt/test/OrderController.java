package org.jwt.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getOrder")
public class OrderController {

	@Autowired
	public OrderService orderservice;

	@RequestMapping("/{orderId}")
	public ResponseEntity<String> getOrder(@PathVariable String orderId) {
		String str = orderservice.getOrder(orderId); 
		return new ResponseEntity<String>(str, HttpStatus.OK);

	}
	
	@RequestMapping("/home")
	public ResponseEntity<String> getOrderHome() { //allowed no password to provide
		String str = "Hello From Home Page"; 
		return new ResponseEntity<String>(str, HttpStatus.OK);

	}
	
	@RequestMapping("/admin")
	public ResponseEntity<String> getAdmin() {//here to provide password 
		String str = "Hello From Admin Page"; 
		return new ResponseEntity<String>(str, HttpStatus.OK);

	}

}
