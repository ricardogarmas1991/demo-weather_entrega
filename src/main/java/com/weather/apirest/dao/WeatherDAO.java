package com.weather.apirest.dao;

import java.util.List;

import com.weather.apirest.entity.Clima;
import com.weather.apirest.entity.totalCiudades;




public interface WeatherDAO {

    public List<totalCiudades> findAll();

    public Clima findById(String id);

    public void save(Clima user);

    public void deleteById(int id);
}