package com.dell.employeestore;

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
public class EmployeeStoreController {
	
	@Autowired
	EmployeeSearchProxy employeeSearchProxy;
	
	@Value("${server.port}")
	String myport;
	
	@Value("${jlc.store.message}")
	String message;
	
	@Value("${jlc.store.welcome}")
	String welcome;
	
	Logger log = LoggerFactory.getLogger(EmployeeStoreController.class);
	
	@GetMapping("/mybooks")
	public List<String> getMyBooks() {
		log.info("---BookStoreController---getMyBooks()---");
		List<String> booksList = employeeSearchProxy.getAllBooks();
		booksList.add(myport);
		booksList.add(message);
		booksList.add(welcome);
		return booksList;
	}
}
