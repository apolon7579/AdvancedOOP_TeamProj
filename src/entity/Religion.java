package entity;

public class Religion implements ListItem {
	private Integer id;
	private Integer nationId;
	private String name;
	private Double percentage;
	
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

	public Religion(Integer id, Integer nationId, String name, Double percentage) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
		this.percentage = percentage;
	}
}
