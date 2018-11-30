package com.sapeint.assessment.x.controller.service;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class XServiceImplTest {

    @Mock
    private XServiceImpl xServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetWeather() {

        JSONObject jsonObject = xServiceImpl.getWeather("Bengaluru");
        try {
            Assert.assertEquals(jsonObject.getString("cod"), "200");
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetWeatherNegative() {

        JSONObject jsonObject = xServiceImpl.getWeather("BengaluruX");
        try {
            Assert.assertEquals(jsonObject.getString("status"), "400");
        } catch (Exception e) {

        }
    }
}