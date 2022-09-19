package com.weather.apirest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="clima")
public class Clima {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
	
	 @Column(name="longitud")
	private float longitud;
	 @Column(name="latitud")
	private float latitud;
	 @Column(name="descripcionClima")
	private String descripcionClima;
	 @Column(name="temperaturaActual")
	private float temperaturaActual;
	 @Column(name="temperaturaMinima")
	private float temperaturaMinima;
	 @Column(name="temperaturaMaxima")
	private float temperaturaMaxima;
	 @Column(name="velicidadDelViente")
	private float velicidadDelViente;
	 @Column(name="nombreCiudad")
	private String nombreCiudad;
	 @Column(name="error")
	private String error;
	 @Column(name="horaDeConsulta")
		private Date horaDeConsulta;


	 
	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public String getDescripcionClima() {
		return descripcionClima;
	}
	
	public void setDescripcionClima(String descripcionClima) {
		this.descripcionClima = descripcionClima;
	}
	
	public float getTemperaturaActual() {
		return temperaturaActual;
	}

	public void setTemperaturaActual(float temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}

	public float getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(float temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public float getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(float temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public float getVelicidadDelViente() {
		return velicidadDelViente;
	}

	public void setVelicidadDelViente(float velicidadDelViente) {
		this.velicidadDelViente = velicidadDelViente;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
	
	public void setHoraDeConsulta(Date horaDeConsulta) {
		this.horaDeConsulta = horaDeConsulta;
	}
	
	public Date getHoraDeConsulta() {
		return horaDeConsulta;
	}
	

}
