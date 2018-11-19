package lab7;

import java.util.ArrayList;

public class Division {
	
	private String name;
	public Team tm;
	private ArrayList<Team>team = new ArrayList<Team>();

	public Division(String string) {
		this.name = string;
	}

	public void add(Team team1) {
		tm = team1;
		team.add(team1);
		
	}

	public int getNumOfTeams() {
		
		return team.size();
	}

	public int getNumOfGoals() {
		
		return tm.getNumOfGoals();
	}

	public double getAvgAge() {
		
		return tm.getAvgAge();
	}

	public int getGoalsDiv() {
		
		return tm.getGoalsDiv();
	}

}
