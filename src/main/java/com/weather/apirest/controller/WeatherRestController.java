package com.weather.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.apirest.entity.Clima;
import com.weather.apirest.entity.Weather2;
import com.weather.apirest.entity.totalCiudades;
import com.weather.apirest.service.WeatherService;



//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/apiExample") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class WeatherRestController {

    //Inyectamos el servicio para poder hacer uso de el
    @Autowired
    private WeatherService userService;


    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
    http://127.0.0.1:8080/api/users/1*/
    @GetMapping("/clima/{ciudad}")
    public Clima getClimaById(@PathVariable String ciudad){
        Clima user = userService.findById(ciudad);
       
        if(user == null) {
            throw new RuntimeException("No se encontro la ciudad -"+ciudad);
        }
        System.out.println(user.toString());
        //retornará al usuario con id pasado en la url
        return user;
    }

  

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
    http://127.0.0.1:8080/api/clima*/
    @PostMapping("/clima")
    public List<totalCiudades> findAll(){
        //retornará todos los usuarios
        return userService.findAll();
    }
  

}