package entity;

public class Media implements ListItem {
	private Integer id;
	private Integer nationId;
	private String name;
	
	public Media(Integer id, Integer nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
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

}
