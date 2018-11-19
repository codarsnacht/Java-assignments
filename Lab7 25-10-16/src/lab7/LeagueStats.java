package lab7;

public class LeagueStats {
	
	private League league;
	private Division div;
	private Team team;

	public void add(League league) {
		this.league = league;
		
	}


	public  int getNumOfDivisions() {
		return league.getNumOfDivisions();
		
	}

	public int getNumOfTeams() {
		
		return league.getNumOfTeams() ;
	}


	public int getNumOfGoals() {
		
		return league.getNumOfGoals();
	}


	public double getAvgAge() {
		
		return league.getAvgAge();
	}


	public int getGoalsDiv() {
		return league.getGoalsDiv();
	}

}
