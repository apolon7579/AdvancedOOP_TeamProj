package Entity;

public class Race {
	private int id;
	private int nationId;
	private String name;
	private double percentage;
	
	public Race(int id, int nationId, String name, double percentage) {
		super();
		this.id = id;
		this.nationId = nationId;
		this.name = name;
		this.percentage = percentage;
	}
}
