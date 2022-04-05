package com.dell.bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class BookStoreController {
	
	@Autowired
	BookSearchProxy bookSearchProxy;
	
	@Value("${server.port}")
	String myport;
	
	@Value("${dell.store.message}")
	String message;
	
	@Value("${dell.store.welcome}")
	String welcome;
	
	@Value("${dell.book.offer}")
	String  Offer;
	
	@Value("${dell.book.actual.value}")
	String  actualPrice;
	
	Logger log = LoggerFactory.getLogger(BookStoreController.class);
	
	@GetMapping("/getMyBooks")
	public List<String> getMyBooks() {
		log.info("---BookStoreController---getMyBooks()---");
		List<String> booksList = bookSearchProxy.getAllBooks();
		booksList.add("---------------------------------------------");
		booksList.add("BookStore Port: "+myport);
		booksList.add("BookStore Message: "+ message);
		booksList.add("BookStore Welcome Message: "+welcome);
		booksList.add("Actual Book Price: "+actualPrice);
		booksList.add("Todays Offer:"+Offer+"%");
		int offerPrice = ((100-Integer.parseInt(Offer))*Integer.parseInt(actualPrice))/100;
		booksList.add("Final Selling Price:"+offerPrice);
		return booksList;
	}
}
