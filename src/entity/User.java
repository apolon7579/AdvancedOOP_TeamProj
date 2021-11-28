package entity;

//유저 객체
public class User {
	private Integer id;
	private String name;
	private String userId;
	private String password;
	private Integer level;
	
	public User(Integer id, String name, String userId, String password, Integer level) {
		super();
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public Integer getLevel() {
		return level;
	}
}
