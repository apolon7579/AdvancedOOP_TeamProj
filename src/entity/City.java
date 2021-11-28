package entity;

//도시 객체
public class City implements ListItem {
	private Integer id;
	private Integer nationId;
	private String name;
	
	public Integer getId() {
		return id;
	}

	public Integer getNationId() {
		return nationId;
	}

	public String getName() {
		return name;
	}

	public City(Integer id, Integer nationId, String name) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
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
