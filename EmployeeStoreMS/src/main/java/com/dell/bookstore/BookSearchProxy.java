package com.dell.bookstore;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "BookSearchMS")
public interface BookSearchProxy {

	@GetMapping("/allbooks")
	public List<String> getAllBooks();
	
}
