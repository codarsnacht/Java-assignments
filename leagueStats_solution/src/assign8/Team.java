package assign8;

import java.util.ArrayList;

public class Team {
	
	private ArrayList<Player> players;
	
	private String name;
	

	public Team(String nm) {
		this.name = nm;
		this.players = new ArrayList<Player>();
	}



	public int getGoals() {
		
		int goals = 0;
		
		for (Player p : players){
			goals+=p.getGoals();
		}
		
		return goals;
	}



	public boolean addPlayer(Player player) {
		
		return this.players.add(player);
		
	}
	
	public String getName(){
		return this.name;
	}



	public double getAverageAge() {
		
		if(players.size()==0){
			return 0;
		}
		double age = 0.0;
		for (Player p : players){
			age+=p.getAge();
		}
	
		return age/players.size();
		
	}

}
