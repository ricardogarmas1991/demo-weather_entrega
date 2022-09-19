package com.weather.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.apirest.dao.WeatherDAO;
import com.weather.apirest.entity.Clima;
import com.weather.apirest.entity.Weather2;
import com.weather.apirest.entity.totalCiudades;



@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherDAO userDAO;


    @Override
    public Clima findById(String id) {
    	
    	
    	Clima response = userDAO.findById(id);
        return response;
    }

    @Override
    public void save(Clima user) {
        userDAO.save(user);

    }

	@Override
	public List<totalCiudades> findAll() {
		List<totalCiudades> lista = userDAO.findAll();
		return lista;
	}


}