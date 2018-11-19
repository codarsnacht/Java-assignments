package assign8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeagueStatsTest {

	LeagueStats leagueStats  = new LeagueStats();

	@Before
	public void setUp() throws Exception {

		League league = new League("League of Ireland");
		leagueStats.add(league);

		Division div1  = new Division("Div1");
		Division div2  = new Division("Div2");


		league.add(div1);
		league.add(div2);

		Team team1 = new Team("Hoops");
		Team team2 = new Team("Rovers");
		Team team3 = new Team("United");
		Team team4= new Team("City");
		Team team5= new Team("Galway United");

		div1.add(team1);
		div1.add(team2);
		div2.add(team3);
		div2.add(team4);
		div1.add(team5);
		
		Player player1 = new Player ("Joe", 7, 22);
		player1.addGoal(6);
		Player player2 = new Player ("John", 2, 18);
		player2.addGoal(3);
		Player player3 = new Player ("Oisin", 3, 28);
		player3.addGoal(2);
		
		Player player4 = new Player ("Aine", 7, 19);
		player4.addGoal(3);
		Player player5 = new Player ("Deirdre", 3, 23);
		player5.addGoal(5);
		Player player6 = new Player ("Katie", 9, 25);
		player6.addGoal(1);
		
		team1.addPlayer(player1);
		team1.addPlayer(player2);
		team1.addPlayer(player3);
		
		team2.addPlayer(player4);
		team2.addPlayer(player5);
		team2.addPlayer(player6);
		
	}



	@Test
	public void getNumDivisionsTest(){

		int expected=2;
		int actualResult= leagueStats.getNumDivisions();
		assertEquals(expected, actualResult);

	}
	
	@Test
	public void getNumTeamsTest() {

		int expected = 5;
		int actual = leagueStats.getNumTeams();
		assertEquals(expected, actual);
	}

	@Test
	public void getNumGoalsForDivisionTest(){
		
		String name = "Div1";
		int expected =20;
		int actual = leagueStats.getNumGoalsForDivision(name);
		assertEquals(expected, actual);
		
		name = "Div2";
		expected =0;
		actual = leagueStats.getNumGoalsForDivision(name);
		assertEquals(expected, actual);
		
		name = "Premiere";
		expected = -1; // no Division found
		actual = leagueStats.getNumGoalsForDivision(name);
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void getNumGoalsForTeamTest(){
		
		String name = "Hoops";
		int expected = 11;
		int actual = leagueStats.getNumGoalsForTeam(name);
		assertEquals(expected, actual);
		
		name = "Rovers";
		expected = 9;
		actual = leagueStats.getNumGoalsForTeam(name);
		assertEquals(expected, actual);
		
	
		name = "United";
		expected =0;
		actual = leagueStats.getNumGoalsForTeam(name);
		assertEquals(expected, actual);
		
		name = "Shamrock";
		expected =-1;
		actual = leagueStats.getNumGoalsForTeam(name);
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void getAverageAgeOfTeamTest(){
		
		String name = "Hoops";
		double expected = 22.67;
		double actual = leagueStats.getAverageAgeOfTeam(name);
		assertEquals(expected, actual, 0.01);
		
		name = "Rovers";
		expected = 22.33;
		actual = leagueStats.getAverageAgeOfTeam(name);
		assertEquals(expected, actual, 0.01);
		
		name = "United";
		expected =0;
		actual = leagueStats.getAverageAgeOfTeam(name);
		assertEquals(expected, actual, 0.01);
		
		name = "Shamrock";
		expected =-1;
		actual = leagueStats.getAverageAgeOfTeam(name);
		assertEquals(expected, actual, 0.01);
	}
	
	
	}
	

