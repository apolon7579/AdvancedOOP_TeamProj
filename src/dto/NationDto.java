package dto;

import java.util.List;

import entity.City;
import entity.Climate;
import entity.Language;
import entity.Media;
import entity.Race;
import entity.Religion;
import entity.User;

public class NationDto {
	private int id;
	private String name;
	private String code;
	private String capital;
	private String location;
	private int area;
	private String areaSource;
	private String areaLocation;
	private int baseYear;
	private List<City> cityList;
	private List<Climate> climateList;
	private List<Language> languageList;
	private List<Media> mediaList;
	private List<Race> raceList;
	private List<Religion> religionList;
	private List<User> userList;
	
	public String getAreaLocation() {
		return areaLocation;
	}
	public void setAreaLocation(String areaLocation) {
		this.areaLocation = areaLocation;
	}
	public int getBaseYear() {
		return baseYear;
	}
	public void setBaseYear(int baseYear) {
		this.baseYear = baseYear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getAreaSource() {
		return areaSource;
	}
	public void setAreaSource(String areaSource) {
		this.areaSource = areaSource;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	public List<Climate> getClimateList() {
		return climateList;
	}
	public void setClimateList(List<Climate> climateList) {
		this.climateList = climateList;
	}
	public List<Language> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(List<Language> languageList) {
		this.languageList = languageList;
	}
	public List<Media> getMediaList() {
		return mediaList;
	}
	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}
	public List<Race> getRaceList() {
		return raceList;
	}
	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}
	public List<Religion> getReligionList() {
		return religionList;
	}
	public void setReligionList(List<Religion> religionList) {
		this.religionList = religionList;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
