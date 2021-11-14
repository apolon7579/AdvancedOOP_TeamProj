package entity;

public class Climate implements ListItem{
	private int id;
	private int nationId;
	private String name;
	
	public Climate(int id, int nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNationId() {
		return nationId;
	}

	public void setNationId(int nationId) {
		this.nationId = nationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
