package com.ecommerce.controller.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecommerce.exceptions.AuthorizationException;
import com.ecommerce.exceptions.UserHasProductsRelationshipsException;
import com.ecommerce.exceptions.ClientOrSellerHasThisSameEntryException;
import com.ecommerce.exceptions.DuplicateEntryException;
import com.ecommerce.exceptions.ObjectNotFoundException;
import com.ecommerce.exceptions.ProductHasAlreadyBeenSold;
import com.ecommerce.exceptions.YouHaveAlreadyAddThisProductInYourWishlistException;

@ControllerAdvice
public class ResourceExceptionHandler {

	
	  @ExceptionHandler(ProductHasAlreadyBeenSold.class)
	    public ResponseEntity<StandardError> productHasAlreadyBeenSold(ProductHasAlreadyBeenSold e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
	                "Product has already been sold", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	    }
	  
	  @ExceptionHandler(ObjectNotFoundException.class)
	    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
	                "Not found", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	    }
	  
	  @ExceptionHandler(DuplicateEntryException.class)
	    public ResponseEntity<StandardError> duplicateEntry(DuplicateEntryException e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
	                "Duplicate entry", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	    }
	  
	  @ExceptionHandler(ClientOrSellerHasThisSameEntryException.class)
	    public ResponseEntity<StandardError> clientOrSellerHasThisSameEntry(ClientOrSellerHasThisSameEntryException e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
	                "Duplicate entry", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	    }
	  
	  @ExceptionHandler(AuthorizationException.class)
	    public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.FORBIDDEN.value(),
	                "Authorization", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	    }
	  @ExceptionHandler(YouHaveAlreadyAddThisProductInYourWishlistException.class)
	    public ResponseEntity<StandardError> duplicateWishlist(YouHaveAlreadyAddThisProductInYourWishlistException e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
	                "Duplicate product in your wishlist", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	    }
	  
	  @ExceptionHandler(UserHasProductsRelationshipsException.class)
	    public ResponseEntity<StandardError> userHasBoughtProduct(UserHasProductsRelationshipsException e, HttpServletRequest request) {

	        StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
	                "It's impossible to delete this entity", e.getMessage(), request.getRequestURI());

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	    }
}
