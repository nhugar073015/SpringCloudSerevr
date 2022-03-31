package com.dell.employeestore;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "MyBookSearchMS")
public interface EmployeeSearchProxy {

	@GetMapping("/allbooks")
	public List<String> getAllBooks();
	
}
