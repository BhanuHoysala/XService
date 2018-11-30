package com.sapeint.assessment.x.controller.service;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import javax.ws.rs.NotFoundException;

@Slf4j
@Service
public class XServiceImpl implements XService {

    @Value("${api.key}")
    private String API_KEY;

    @Override
    public String getXMessage() {

        return "Welcome to X Service";
    }

    @Override
    public JSONObject getWeather(String city) throws NotFoundException {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city
                + "&mode=json&appid=d2929e9483efc82c82c32ee7e02d563e&units=Metric";

        String response = restTemplate.getForObject(url, String.class);
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.get("cod").equals("404")) {
            throw new NotFoundException("city " + city + " not found");
        }
        log.info("payload received {}", jsonObject);
        return new JSONObject(response);
    }

}
