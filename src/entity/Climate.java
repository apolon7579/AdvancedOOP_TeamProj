package entity;

//기후 객체
public class Climate implements ListItem{
	private Integer id;
	private Integer nationId;
	private String name;
	
	public Climate(Integer id, Integer nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNationId() {
		return nationId;
	}

	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
