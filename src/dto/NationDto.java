package dto;

import java.util.List;

import entity.City;
import entity.Climate;
import entity.Language;
import entity.Media;
import entity.Nation;
import entity.Race;
import entity.Religion;
import entity.User;

public class NationDto {
	private Integer id;
	private String name;
	private String code;
	private String capital;
	private List<Climate> climateList;
	private String location;
	private List<City> cityList;
	private List<Religion> religionList;
	private List<Race> raceList;
	private List<Media> mediaList;
	private Double area;
	private String areaSource;
	private String areaLocation;
	private List<Language> languageList;
	private Integer baseYear;
	private List<User> userList;
	
	public NationDto() {
	}
	public NationDto(Integer id, String name, String code, String capital, List<Climate> climateList, String location,
			List<City> cityList, List<Religion> religionList, List<Race> raceList, List<Media> mediaList, Double area,
			String areaSource, String areaLocation, List<Language> languageList, Integer baseYear, List<User> userList) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.capital = capital;
		this.climateList = climateList;
		this.location = location;
		this.cityList = cityList;
		this.religionList = religionList;
		this.raceList = raceList;
		this.mediaList = mediaList;
		this.area = area;
		this.areaSource = areaSource;
		this.areaLocation = areaLocation;
		this.languageList = languageList;
		this.baseYear = baseYear;
		this.userList = userList;
	}
	public Nation getNation() {
		return new Nation(id, name, code, capital, location, area, areaSource, areaLocation, baseYear);
	}
	public String getAreaLocation() {
		return areaLocation;
	}
	public void setAreaLocation(String areaLocation) {
		this.areaLocation = areaLocation;
	}
	public Integer getBaseYear() {
		return baseYear;
	}
	public void setBaseYear(Integer baseYear) {
		this.baseYear = baseYear;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
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
	@Override
	public String toString() {
		return "NationDto [id=" + id + ", name=" + name + ", code=" + code + ", capital=" + capital + ", climateList="
				+ climateList + ", location=" + location + ", cityList=" + cityList + ", religionList=" + religionList
				+ ", raceList=" + raceList + ", mediaList=" + mediaList + ", area=" + area + ", areaSource="
				+ areaSource + ", areaLocation=" + areaLocation + ", languageList=" + languageList + ", baseYear="
				+ baseYear + ", userList=" + userList + "]";
	}
}
