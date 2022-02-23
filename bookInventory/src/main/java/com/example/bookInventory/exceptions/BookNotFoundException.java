package com.example.bookInventory.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class BookNotFoundException extends Exception {
	public BookNotFoundException(String x) {
		super("No such book: " + x);
	}
}
