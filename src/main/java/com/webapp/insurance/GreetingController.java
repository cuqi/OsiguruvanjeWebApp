package com.webapp.insurance;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@Value("${spring.application.name}")
	String appName;

	@PostMapping("/test")
	public String handlePostRequest(String visitorName) {
	return "redirect:/visitor";
	}

	@GetMapping("/test")
	public String handleGetRequest(Model model) {
	return "visitor-view";
	}

}