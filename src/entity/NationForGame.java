package entity;

public class NationForGame {
	private String name;
	private String code;
	private int area;
	private String capital;
	private String location;
	private String city;
	private String language;
	private String climate;
	private String religion;
	private String race;
	
	public NationForGame(String name, String code, int area, String capital, String location, String city,
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

	public int getArea() {
		return area;
	}
	
	
}
