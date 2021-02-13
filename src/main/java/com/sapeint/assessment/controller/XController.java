package com.sapeint.assessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/welcome")
public class XController {

	@GetMapping
	public String welcome() {
		return "Hello, Welcome";
	}
}
