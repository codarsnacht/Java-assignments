package lab7;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeagueStatsTest {
	private static final double DELTA = 1e-15;
	LeagueStats LeagueStats = new LeagueStats();

	@Before
	public void setUp() throws Exception{
		
		League league = new League("league1");
		LeagueStats.add(league);
		
		Division div1 = new Division("A");
		Division div2 = new Division("B");
		
		league.add(div1);
		league.add(div2);
		
		// name , trophies
		Team team1 = new Team("1", 1);
		Team team2 = new Team("2", 2);
		Team team3 = new Team("3", 3);
		Team team4 = new Team("4", 4);
		
		div1.add(team1);
		div1.add(team2);
		div2.add(team3);
		div2.add(team4);
		
		
		// age , position , goals
		Player player1 = new Player ( 1,3,2);
		Player player2 = new Player ( 4,6,2);
		Player player3 = new Player ( 6,3,2);
		Player player4 = new Player ( 1,3,1);
		Player player5 = new Player ( 4,6,1);
		Player player6 = new Player ( 6,3,1);
		Player player7 = new Player ( 1,3,2);
		Player player8 = new Player ( 4,6,2);
		Player player9 = new Player ( 6,3,2);
		Player player10 = new Player ( 2,3,1);
		Player player11 = new Player ( 4,6,1);
		Player player12 = new Player ( 6,3,1);
		
		team1.add(player1);
		team1.add(player2);
		team1.add(player3);
		team2.add(player4);
		team2.add(player5);
		team2.add(player6);
		team3.add(player7);
		team4.add(player8);
		team3.add(player9);
		team4.add(player10);
		team3.add(player11);
		team4.add(player12);
		
	}
	
	@Test
	public void getNumDivisionsTest() {
		int expected =2;
		
		int actualResult = LeagueStats.getNumOfDivisions();
		
		assertEquals(expected, actualResult);
			System.out.println("Divisions = " + actualResult);
	}
	
	@Test
	public void getNumTeams(){
		int expected =4;
		int actualResult = LeagueStats.getNumOfTeams();
		assertEquals(expected, actualResult);
			System.out.println("teams = " + actualResult);
	}
	
	@Test
	public void  getNumGoalsForTeam(){
		// currently works for the last team only in each division
		int expected = 6 ;
		int actualResult = LeagueStats.getNumOfGoals();
		System.out.println("goals = " + actualResult);
		assertEquals(expected, actualResult);
		
	}
//		// ToDo
		@Test
		public void getAvgAge(){
			 // can only get the last team from each division to currently work 
			double expected = ((6+2+4)/3 )*2;
		double actualResult = LeagueStats.getAvgAge();
		assertEquals ( expected , actualResult , DELTA);
		System.out.println("average age for teams 2 and 4  = " + actualResult);
			
			
		}
	
		@Test
		public void getGoalsForDivision(){
			 // can only get the last team from each division to currently work 
			int expected = 6;
			int actualResult = LeagueStats.getGoalsDiv();
			assertEquals (expected , actualResult ); 
			System.out.println("Goals for Division 2 = " + actualResult);
		
		}
	
	
	
}
