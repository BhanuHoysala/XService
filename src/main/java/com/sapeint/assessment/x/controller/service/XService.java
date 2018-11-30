package com.sapeint.assessment.x.controller.service;

import org.json.JSONObject;

public interface XService {
    String getXMessage();

    JSONObject getWeather(String city);
}
