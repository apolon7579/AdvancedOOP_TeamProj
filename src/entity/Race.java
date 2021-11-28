package entity;

//인종 객체
public class Race implements ListItem {
	private Integer id;
	private Integer nationId;
	private String name;
	private Double percentage;
	
	public Race(Integer id, Integer nationId, String name, Double percentage) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
		this.percentage = percentage;
	}

	public Integer getId() {
		return id;
	}

	public Integer getNationId() {
		return nationId;
	}

	public String getName() {
		return name;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}


}
