package assign8;

public class LeagueStats {
	
	private League league;

	public void add(League lg) {
	
		this.league=lg; 
	}

	public int getNumDivisions(){
		return league.getNumDivisions();
	}
	
	public int getNumTeams(){
		return league.getNumTeams();
	}
	
	public int getNumGoalsForDivision(String div){
		return league.getNumGoalsForDivision(div);
	}
	
	public int getNumGoalsForTeam(String team){
		return league.getNumGoalsForTeam(team);
	}

	public double getAverageAgeOfTeam(String name) {
		
		return league.getAverageAgeOfTeam(name);
	}
}
