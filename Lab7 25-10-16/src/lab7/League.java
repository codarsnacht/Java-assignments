package lab7;

import java.util.ArrayList;

public class League {
	private Division div;
	private Division div1;
	private String name; 
	private ArrayList<Division>divisions = new ArrayList<Division>();

	public League(String string) {
		this.name = string;
	}

	public void add(Division div1) {
		//gets the div 1 and then div2
		div = div1;
		divisions.add(div1);
		this.div1 = div1;
		
	}	

	public int getNumOfDivisions() {
		
		return divisions.size();
	}
// needed as it would only work for div2 without div1."method"()
	public int getNumOfTeams() {
		
		return div.getNumOfTeams() + div1.getNumOfTeams();
		
	}

	public int getNumOfGoals() {
		
		return div.getNumOfGoals() + div1.getNumOfGoals();
	}

	public double getAvgAge() {
		
		return div.getAvgAge() +  div1.getAvgAge();
	}

	public int getGoalsDiv() {
		return div.getGoalsDiv() + div1.getGoalsDiv();
	}

}
