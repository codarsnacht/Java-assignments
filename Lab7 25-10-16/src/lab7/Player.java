package lab7;

public class Player {
	public static int getNumOfGoals ;
	private int age;
	private static int goals;
	private int position;
	
	
	public Player(int age , int position, int goals ){
		this.age = age;
		this.position = position ;
		this.goals = goals;
		
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static int getGoals() {
		return goals;
	}


	public void setGoals(int goals) {
		this.goals = goals;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}

}