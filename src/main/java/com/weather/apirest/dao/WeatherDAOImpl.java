package com.weather.apirest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.weather.apirest.entity.JsonTranform;
import com.weather.apirest.entity.Clima;
import com.weather.apirest.entity.Weather2;
import com.weather.apirest.entity.totalCiudades;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



@Repository
public class WeatherDAOImpl implements WeatherDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<totalCiudades> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

      //  Query<String> theQuery = currentSession.createQuery("select * from clima limit 10",String.class);
        
        SQLQuery query = currentSession.createSQLQuery("select count(*) as total, nombre_ciudad from clima group by  nombre_ciudad limit 10");
        List<Object[]> rows = query.list();
        List<totalCiudades> listaCiudades = new ArrayList<totalCiudades>();
        for(Object[] row : rows){        	 
        	totalCiudades totalCiudad = new totalCiudades();
             totalCiudad.setTotal(Integer.parseInt(row[0].toString()));
             totalCiudad.setCiudad(row[1].toString());
             listaCiudades.add(totalCiudad);
        }

        return listaCiudades;

    }

    @Override
    public Clima findById(String id) {
    	Clima responseGet = new Clima();
    	try {
    		OkHttpClient client = new OkHttpClient();
    		
        	Request request = new Request.Builder()
        		.url("https://api.openweathermap.org/data/2.5/weather?q="+id+"&appid=f80b0ad0364b071eb165e7c6c9f14787")
        		.get()
//        		.addHeader("X-RapidAPI-Key", "f80b0ad0364b071eb165e7c6c9f14787")
//        		.addHeader("X-RapidAPI-Host", "open-weather13.p.rapidapi.com")
        		.build();

        	Response response = client.newCall(request).execute();
        	String jsonRespuesta = response.body().string();
        	System.out.println(jsonRespuesta);
        	
        	if(jsonRespuesta.contains("city not found")) {
        		responseGet.setError("LA CIUDAD "+id.toUpperCase()+" NO EXISTE");
            	return responseGet;
        	}
        	
        	//Parseando el objeto
        	Gson gson = new Gson();
        	JsonTranform transformJson = gson.fromJson(jsonRespuesta, JsonTranform.class);
        	System.out.println(transformJson);
        	
        	responseGet.setNombreCiudad(transformJson.getName());
        	responseGet.setLongitud(transformJson.getCoord().getLon());
        	responseGet.setLatitud(transformJson.getCoord().getLat());
        	responseGet.setDescripcionClima(transformJson.getWeather().get(0).getDescription());
        	responseGet.setTemperaturaActual(transformJson.getMain().getTemp());
        	responseGet.setTemperaturaMaxima(transformJson.getMain().getTemp_max());
        	responseGet.setTemperaturaMinima(transformJson.getMain().getTemp_min());
        	responseGet.setVelicidadDelViente(transformJson.getWind().getSpeed());
        	responseGet.setHoraDeConsulta(new Date());
        	responseGet.setError("");
        	
        	save(responseGet);
        	
        	return responseGet;
		} catch (Exception e) {
			e.printStackTrace();
			responseGet.setError("OCURRIO UN ERROR AL OBTENER LA INFORMACION");
			 return responseGet;
		}

    	
       
    }

    @Override
    public void save(Clima user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);  

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Weather2> theQuery = currentSession.createQuery("delete from User where id=:idUser");

        theQuery.setParameter("idUser", id);
        theQuery.executeUpdate();

    }


}