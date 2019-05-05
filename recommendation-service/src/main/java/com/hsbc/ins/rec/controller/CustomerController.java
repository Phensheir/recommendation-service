package com.hsbc.ins.rec.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsbc.ins.rec.domain.Customer;
import com.hsbc.ins.rec.response.JsonResult;
import com.hsbc.ins.rec.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@ResponseBody
	@PostMapping(value = "loginTo", produces = "application/json;charset=UTF-8")
	public JsonResult login(@RequestBody final String jsonString) throws JsonProcessingException {
		JsonResult jsonResult = null;
		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer = customerService.identify("user41", "e10adc3949ba59abbe56e057f20f883e");
		if(null != customer) {
			jsonResult = JsonResult.success("Login SUCCESS", customer);
		}else {
			jsonResult = JsonResult.fail("Login FAILURE", "User name or password is incorrect.");
		}
		return jsonResult;
	}
}
