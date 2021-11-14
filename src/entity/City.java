package entity;

public class City implements ListItem {
	private int id;
	private int nationId;
	private String name;
	
	public int getId() {
		return id;
	}

	public int getNationId() {
		return nationId;
	}

	public String getName() {
		return name;
	}

	public City(int id, int nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
	}
}
