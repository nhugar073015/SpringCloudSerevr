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

	@GetMapping("/allbooks")
	public Books getAllBooks() {
		Books books = new Books();
		log.info("---BookSearchController---getAllBooks()---");
		log.info("---Port--- : " + myport);
		log.info("---message--- : " + message);
		List<String> booksList = new ArrayList<String>();
		booksList.add("1. Core Java");
		booksList.add("2. Spring Boot");
		booksList.add("3. Microservices");
		books.setMyport(myport);
		books.setMessage(message);
		books.setOfferInPerc(Offer);
		books.setActualBookPrice(actualPrice);
		int offerPrice = ((100-Integer.parseInt(Offer))*Integer.parseInt(actualPrice))/100;
		books.setOfferedPrice("*Offer Price*:"+offerPrice);
		return books;
	}
}
