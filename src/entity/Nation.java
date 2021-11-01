package entity;

public class Nation {
	private int id;
	private String name;
	private String code;
	private String capital;
	private String location;
	private int area;
	private String areaSource;
	public int getId() {
		return id;
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

	public int getArea() {
		return area;
	}

	public String getAreaSource() {
		return areaSource;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public int getBaseYear() {
		return baseYear;
	}

	private String areaDescription;
	private int baseYear;
	
	public Nation(int id, String name, String code, String capital, String location, int area, String areaSource,
			String areaDescription, int baseYear) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.capital = capital;
		this.location = location;
		this.area = area;
		this.areaSource = areaSource;
		this.areaDescription = areaDescription;
		this.baseYear = baseYear;
	}
	
	
}
