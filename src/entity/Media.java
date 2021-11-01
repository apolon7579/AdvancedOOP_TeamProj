package entity;

public class Media {
	private int id;
	public int getId() {
		return id;
	}

	public int getNationId() {
		return nationId;
	}

	public String getName() {
		return name;
	}

	private int nationId;
	private String name;
	
	public Media(int id, int nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
	}
}
