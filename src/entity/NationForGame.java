package entity;

//게임을 위한 국가 객체
public class NationForGame {
	private String name;
	private String code;
	private Double area;
	private String capital;
	private String location;
	private String city;
	private String language;
	private String climate;
	private String religion;
	private String race;

	public NationForGame(String name, String code, Double area, String capital, String location, String city,
			String language, String climate, String religion, String race) {
		super();
		this.name = name;
		this.code = code;
		this.area = area;
		this.capital = capital;
		this.location = location;
		this.city = city;
		this.language = language;
		this.climate = climate;
		this.religion = religion;
		this.race = race;
	}
	

	public Double getArea() {
		return area;
	}

	public String getName() {
		return name;
	}



	public String getCode() {
		return code;
	}



	public String getCapital() {
		return capital;
	}



	public String getLocation() {
		return location;
	}



	public String getCity() {
		return city;
	}



	public String getLanguage() {
		return language;
	}



	public String getClimate() {
		return climate;
	}



	public String getReligion() {
		return religion;
	}



	public String getRace() {
		return race;
	}
	
	@Override
	public String toString() {
		return String.format("나라이름: %s\n국가코드: %s\n면적: %d\n수도: %s\n위치: %s\n주요도시: %s\n언어: %s\n기후: %s\n종교: %s\n인종: %s",
				name, code, area, capital, location, city, language, climate, religion, race);
	}

}
