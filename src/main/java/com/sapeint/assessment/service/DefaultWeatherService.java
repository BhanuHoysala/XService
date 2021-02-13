package com.sapeint.assessment.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sapeint.assessment.exceptions.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultWeatherService extends AbstractService implements WeatherService {

	@Value("${api.key}")
	private String API_KEY;

	@Override
	public JSONObject getWeather(String city) throws NotFoundException {

		final String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city
			+ "&mode=json&appid=d2929e9483efc82c82c32ee7e02d563e&units=Metric";

		String response = null;
		try {
			response = restTemplate.getForObject(url, String.class);
		} catch (HttpClientErrorException e) {
			if (e.getStatusCode().value() == HttpStatus.NOT_FOUND.value()) {
				throw new NotFoundException(String.format(NotFoundException.REQUESTED_DATA_NOT_AVAILABLE, city));
			}
		}
		JSONObject jsonObject = new JSONObject(response);
		try {
			log.info("payload received {}", formatJson(jsonObject.toString()));
		} catch (JsonProcessingException e) {
			log.error("error in logging JSON", e);
		}
		return jsonObject;
	}

}
