package com.ecommerce.services;

import com.ecommerce.security.ClientSS;
import com.ecommerce.security.SellerSS;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {



	// return the user logged in the system

	public static ClientSS clientAuthenticated() {
		try {
			return (ClientSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		} catch (Exception e) {
			return null;
		}
	}

	public static SellerSS sellerAuthenticated() {
		try {
			return (SellerSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		} catch (Exception e) {
			return null;
		}
	}


}