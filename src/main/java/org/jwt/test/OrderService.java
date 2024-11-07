package org.jwt.test;

import org.springframework.stereotype.Service;

@Service
public class OrderService { 
	
	public String getOrder(String orderId) {

		String str = "I am your Order No-"+orderId; 
		return str;
		
	}

	
	
	
}

