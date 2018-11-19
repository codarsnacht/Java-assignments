package assign8;

import java.util.ArrayList;

public class Division {
	private String name;
	private ArrayList<Team> teams;
	
	public Division(String string){
		this.name=string;
		this.teams = new ArrayList<Team>();
	}
	
	public boolean add(Team team){
		return this.teams.add(team);
	}
	
	public String getName(){
		return this.name;
	}

	public int size() {
		
		return teams.size();
	}

	public int getNumGoals() {
		
		int goals = 0;
		
		for (Team team : teams){
			
			goals+=team.getGoals();
		}
		
		return goals;
	}
	
	public Team getTeam(String name){
		
		for (Team team: teams){
			if(team.getName().equals(name)){
				return team;
			}
		}
		
		return null;
	}

}
