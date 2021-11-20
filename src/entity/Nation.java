package entity;

public class Nation {
	private Integer id;
	private String name;
	private String code;
	private String capital;
	private String location;
	private Double area;
	private String areaSource;
	private String areaDescription;
	private Integer baseYear;
	
	public Nation(Integer id, String name, String code, String capital, String location, Double area, String areaSource,
			String areaDescription, Integer baseYear) {
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
	
	public Integer getId() {
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

	public Double getArea() {
		return area;
	}

	public String getAreaSource() {
		return areaSource;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public Integer getBaseYear() {
		return baseYear;
	}

	
	
}
