package com.bu2.nam.weatherAPI.modelDTO;

public class WrapperCityWeather {
	private CityDTO city;
	private CloudsDTO clouds;
	private CoordDTO coord;
	private MainDTO main;
	private SysDTO sys;
	private WeatherDTO weather;
	private WindDTO wind;
	
	private Long id;
	private String name;
	private Long cod;
	private Long timezone;
	private Long dt;
	private Long visibility;
	private String base;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public Long getTimezone() {
		return timezone;
	}
	public void setTimezone(Long timezone) {
		this.timezone = timezone;
	}
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	public Long getVisibility() {
		return visibility;
	}
	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public CityDTO getCity() {
		return city;
	}
	public void setCity(CityDTO city) {
		this.city = city;
	}
	public CloudsDTO getClouds() {
		return clouds;
	}
	public void setClouds(CloudsDTO clouds) {
		this.clouds = clouds;
	}
	public CoordDTO getCoord() {
		return coord;
	}
	public void setCoord(CoordDTO coord) {
		this.coord = coord;
	}
	public MainDTO getMain() {
		return main;
	}
	public void setMain(MainDTO main) {
		this.main = main;
	}
	public SysDTO getSys() {
		return sys;
	}
	public void setSys(SysDTO sys) {
		this.sys = sys;
	}
	public WeatherDTO getWeather() {
		return weather;
	}
	public void setWeather(WeatherDTO weather) {
		this.weather = weather;
	}
	public WindDTO getWind() {
		return wind;
	}
	public void setWind(WindDTO wind) {
		this.wind = wind;
	}

}
