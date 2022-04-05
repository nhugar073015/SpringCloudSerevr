package com.dell.booksearch;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class BookSearchController {

	Logger log = LoggerFactory.getLogger(BookSearchController.class);
	@Value("${server.port}")
	String myport;
	@Value("${dell.search.message}")
	String message;
	@Value("${dell.book.offer}")
	String  Offer;
	@Value("${dell.book.actual.value}")
	String  actualPrice;
	@Value("${dell.search.welcome}")
	String welcome;

	@GetMapping("/getAllBooks")
	public List<String> getAllBooks() {
		log.info("---BookSearchController---getAllBooks()---");
		log.info("---Port--- : " + myport);
		log.info("---message--- : " + message);
		List<String> booksList = new ArrayList<String>();
		booksList.add("1. Core Java");
		booksList.add("2. Spring Boot");
		booksList.add("3. Microservices");
		booksList.add("------------------------------------");
		booksList.add("BookSearch Port: "+myport);
		booksList.add("BookSearch Message: "+message);
		booksList.add("BookSearch Welcome Message: "+welcome);
		booksList.add("Actual Book Price: "+actualPrice);
		booksList.add("Todays Offer:"+Offer+"%");
		int offerPrice = ((100-Integer.parseInt(Offer))*Integer.parseInt(actualPrice))/100;
		booksList.add("Final Selling Price:"+offerPrice);
		return booksList;
	}
}
