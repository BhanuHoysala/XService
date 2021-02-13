package com.sapeint.assessment.service;

import org.json.JSONObject;

import com.sapeint.assessment.exceptions.NotFoundException;

public interface WeatherService {

    JSONObject getWeather(String city) throws NotFoundException;
}
