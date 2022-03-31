package com.dell.bookstore;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.dell.booksearch.Books;

@FeignClient(name = "EmployeeSearchMS")
public interface BookSearchProxy {

	@GetMapping("/allbooks")
	public Books getAllBooks();
	
}
