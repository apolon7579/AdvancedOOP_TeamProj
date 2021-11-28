package entity;

//언어 객체
public class Language implements ListItem{
	private Integer id;
	private Integer nationId;
	private String name;
	
	public Language(Integer id, Integer nationId, String name) {
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
