package assign8;

public class Player {
	
	private  String name;
	private int position;
	private int goals = 0;
	private int age;

	public Player(String nm, int pos, int years) {
		this.name = nm;
		this.position = pos;
		this.age = years ;
		
	}

	public void addGoal(int i) {
		this.goals+=i;
		
	}

	public int getGoals() {
		return this.goals;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getAge() {
		return this.age;
	}

}
