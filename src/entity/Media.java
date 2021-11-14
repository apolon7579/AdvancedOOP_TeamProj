package entity;

public class Media implements ListItem {
	private int id;
	private int nationId;
	private String name;
	
	public Media(int id, int nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public int getNationId() {
		return nationId;
	}

	public String getName() {
		return name;
	}

}
