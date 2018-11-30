package com.sapeint.assessment.x.controller;

import com.sapeint.assessment.x.controller.service.XService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestController
@RequestMapping("/v1")
public class XController {

    @Autowired
    private XService xService;

    @GetMapping(value = "/welcome")
    public String welcome() {

        return xService.getXMessage();
    }

    @GetMapping(value = "/{city}", produces = "application/json")
    public String getCityWeather(@PathVariable("city") String city) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = xService.getWeather(city);
        } catch (HttpClientErrorException hce) {
            jsonObject.put("message", hce.getStatusText());
            jsonObject.put("status", hce.getRawStatusCode());
        } catch (Exception e) {
            log.error("Exception occurred while fetching X data", e);
            jsonObject.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return jsonObject.toString();
    }
}
