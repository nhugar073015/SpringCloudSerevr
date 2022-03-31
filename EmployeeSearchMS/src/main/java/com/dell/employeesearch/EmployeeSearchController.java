package com.dell.employeesearch;

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
public class EmployeeSearchController {

	Logger log = LoggerFactory.getLogger(EmployeeSearchController.class);
	@Value("${server.port}")
	String myport;
	@Value("${jlc.search.message}")
	String message;
	@Value("${jlc.search.welcome}")
	String welcome;

	@GetMapping("/allbooks")
	public List<String> getAllBooks() {
		log.info("---BookSearchController---getAllBooks()---");
		log.info("---Port--- : " + myport);
		log.info("---message--- : " + message);
		List<String> booksList = new ArrayList<String>();
		booksList.add("Java");
		booksList.add("Spring");
		booksList.add("Spring Boot");
		booksList.add("Angular");
		booksList.add("React");
		booksList.add(myport);
		booksList.add(message);
		booksList.add(welcome);
		return booksList;
	}
}
