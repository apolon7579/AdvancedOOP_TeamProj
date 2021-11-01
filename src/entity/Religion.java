package entity;

public class Religion {
	private int id;
	private int nationId;
	private String name;
	private double percentage;
	
	public int getId() {
		return id;
	}

	public int getNationId() {
		return nationId;
	}

	public String getName() {
		return name;
	}

	public double getPercentage() {
		return percentage;
	}

	public Religion(int id, int nationId, String name, double percentage) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
		this.percentage = percentage;
	}
}
