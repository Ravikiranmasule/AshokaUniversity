package com.ashokclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnquiryController {
	
	@GetMapping("/dashboard")
	public String dashboardPage() {
		return "dashboard";
	}
	
	@GetMapping("/addEnquiry")
	public String enquiryPage() {
		return "addEnquiry";
	}
	
	@GetMapping("/viewEnquiry")
	public String viewEnquiryPage() {
		return "viewEnquiry";
	}

}
