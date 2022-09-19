package com.weather.apirest.entity;

import java.util.ArrayList;

public class JsonTranform {
 Coord coord;
 ArrayList < Weather > weather = new ArrayList < Weather > ();
 private String base;
 Main main;
 private float visibility;
 Wind wind;
 Clouds clouds;
 private float dt;
 Sys sys;
 private float timezone;
 private float id;
 private String name;
 private float cod;


 // Getter Methods 

 public Coord getCoord() {
  return coord;
 }

 public String getBase() {
  return base;
 }

 public Main getMain() {
  return main;
 }

 public float getVisibility() {
  return visibility;
 }

 public Wind getWind() {
  return wind;
 }

 public Clouds getClouds() {
  return clouds;
 }

 public float getDt() {
  return dt;
 }

 public Sys getSys() {
  return sys;
 }

 public float getTimezone() {
  return timezone;
 }

 public float getId() {
  return id;
 }

 public String getName() {
  return name;
 }

 public float getCod() {
  return cod;
 }

 // Setter Methods 

 public void setCoord(Coord coord) {
  this.coord = coord;
 }

 public void setBase(String base) {
  this.base = base;
 }

 public void setMain(Main main) {
  this.main = main;
 }

 public void setVisibility(float visibility) {
  this.visibility = visibility;
 }

 public void setWind(Wind wind) {
  this.wind = wind;
 }

 public void setClouds(Clouds clouds) {
  this.clouds = clouds;
 }

 public void setDt(float dt) {
  this.dt = dt;
 }

 public void setSys(Sys sys) {
  this.sys = sys;
 }

 public void setTimezone(float timezone) {
  this.timezone = timezone;
 }

 public void setId(float id) {
  this.id = id;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setCod(float cod) {
  this.cod = cod;
 }

public ArrayList<Weather> getWeather() {
	return weather;
}

public void setWeather(ArrayList<Weather> weather) {
	this.weather = weather;
}
 
 
 
}



