package com.sapeint.assessment.service;

import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sapeint.assessment.SapientAssessmentApplicationTests;
import com.sapeint.assessment.exceptions.NotFoundException;

import lombok.SneakyThrows;

class DefaultWeatherServiceTest extends SapientAssessmentApplicationTests {

	@Autowired
	private DefaultWeatherService target;

	@BeforeAll
	public void setUp() {
	}

	@SneakyThrows
	@Test
	void testGetWeather() {
		JSONObject jsonObject = target.getWeather("Bengaluru");

		Assertions.assertThat(jsonObject.getString("cod")).isEqualTo("200");
	}

	@Test
	void testGetWeatherNegative() {
		final String bengaluruX = "BengaluruX";

		Assertions.assertThatThrownBy (() -> target.getWeather(bengaluruX))
		.isInstanceOf(NotFoundException.class)
		.hasMessage(String.format(NotFoundException.REQUESTED_DATA_NOT_AVAILABLE, bengaluruX));
	}
}