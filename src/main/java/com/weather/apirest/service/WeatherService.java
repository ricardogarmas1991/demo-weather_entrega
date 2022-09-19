package com.weather.apirest.service;

import java.util.List;

import com.weather.apirest.entity.Clima;
import com.weather.apirest.entity.Weather;
import com.weather.apirest.entity.totalCiudades;



public interface WeatherService {

    public List<totalCiudades> findAll();

    public Clima findById(String id);

    public void save(Clima user);


}