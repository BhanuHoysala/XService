/*
 * Copyright (c) 2021 Payoneer Germany GmbH. All rights reserved.
 */
package com.sapeint.assessment.controller;

import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapeint.assessment.exceptions.NotFoundException;
import com.sapeint.assessment.model.City;
import com.sapeint.assessment.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

	@GetMapping(value = "/{city}", produces = "application/json")
	public String getCityWeather(@PathVariable("city") String city) {

		JSONObject jsonObject;
		try {
			jsonObject = weatherService.getWeather(city);
		} catch (NotFoundException nfEx) {
			log.info(nfEx.getMessage());
			jsonObject = new JSONObject();
			jsonObject.put("message", nfEx.getMessage());
		} catch (Exception e) {
			log.error("Exception occurred while fetching X data", e);
			jsonObject = new JSONObject();
			jsonObject.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return jsonObject.toString();
	}

	@PostMapping("/city")
	public City city(@RequestBody City city) {

		return City.builder()
			.id(UUID.randomUUID())
			.country(city.getCountry())
			.name(city.getName())
			.build();
	}
}
