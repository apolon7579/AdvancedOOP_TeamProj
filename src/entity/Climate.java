package entity;

public class Climate {
	private int id;
	private int nationId;
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

	private String name;
	
	public Climate(int id, int nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
	}
	
}
