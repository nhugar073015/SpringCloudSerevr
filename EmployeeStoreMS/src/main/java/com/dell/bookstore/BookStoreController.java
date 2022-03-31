package com.dell.bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.booksearch.Books;

@RestController
@RefreshScope
public class BookStoreController {
	
	@Autowired
	BookSearchProxy employeeSearchProxy;
	
	@Value("${server.port}")
	String myport;
	
	@Value("${dell.store.message}")
	String message;
	
	Logger log = LoggerFactory.getLogger(BookStoreController.class);
	
	@GetMapping("/mybooks")
	public Books getMyBooks() {
		log.info("---BookStoreController---getMyBooks()---");
		Books booksList = employeeSearchProxy.getAllBooks();
		booksList.setMyport(myport);
		booksList.setMessage(message);
		return booksList;
	}
}
