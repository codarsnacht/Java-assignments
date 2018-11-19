package lab7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Team {
	
	private String name;
	private int trophies ;
	private ArrayList<Player> myPlayers = new ArrayList<Player>() ;
	
	public Team(String string , int trophies) {
		this.name = string;
		this.setTrophies(trophies);
		
		
		}
		
public int getNumOfPlayers() {
		
		System.out.println( "number of players = " + myPlayers.size());
		return myPlayers.size();
	}
	
	public void add(Player player){
		this.myPlayers.add(player);
		
		}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTrophies() {
		return trophies;
	}

	public void setTrophies(int trophies) {
		this.trophies = trophies;
	}
	
	
// Returns info about the last team in each division , so only info on teams 2 and 4 are being found
	public int getNumOfGoals() {
		int Gaols = 0;
	
		for (Player p : myPlayers){
			 Gaols += p.getGoals();
			 
		}
		// works for last team in array only
		
		return Gaols;
	}
// works only for the last team in each division
	public double getAvgAge() {
		double age =0;
		for (Player p : myPlayers){
			 age += p.getAge();
			 
		}
		
		
		return age/myPlayers.size() ;
	}

	public int getGoalsDiv() {
		{
			
			int goals =0;
			for (Player p: myPlayers){
				 goals += p.getGoals();
				 
			}
			
			
			return goals ;
		
	}
	}


}
	


