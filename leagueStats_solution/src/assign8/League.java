package assign8;
import java.util.ArrayList;
public class League {


	private String name;
	private ArrayList<Division> divisions = new ArrayList<Division>();

	public League(String string) {
		this.name=string;

	}

	public void add(Division div1) {
		divisions.add(div1);
	}

	public int getNumDivisions() {
		return divisions.size();

	}

	public int getNumTeams(){

		int numTeams =0;
		for (Division div: divisions){
			numTeams+= div.size();

		}
		return numTeams;
	}

	public int getNumGoalsForDivision(String name) {

		Division div;
		for (int i = 0; i< divisions.size(); i++){
			if(divisions.get(i).getName().equals(name)){
				div = divisions.get(i);
				return div.getNumGoals();
			}
		}


		return -1; // no division found
	}

	public int getNumGoalsForTeam(String teamName) {

		Team team =teamSearch(teamName);
		
			if (team!=null){
				return team.getGoals();
			}
		return -1;
	}

	public double getAverageAgeOfTeam(String teamName) {

		Team team =teamSearch(teamName);
		
		if (team!=null){
			return team.getAverageAge();
		}
	return -1;
	}

	public Team teamSearch(String name){

		Team team = null;
		for(Division div: divisions){
			team = div.getTeam(name);
			if (team!=null){
				return team;
			}
		}
		return null;
	}
	
	public String getName(){
		return this.name;
	}
}
