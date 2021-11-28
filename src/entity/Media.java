package entity;

//매체 객체
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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public void setName(String name) {
		this.name = name;
	}

}
