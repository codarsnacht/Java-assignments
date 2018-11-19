package week6;

public class NaturesCruel {

	public static void main(String[] args) {
		
		Animal[] animal = new Animal[9];
		
		 animal[0] = new Canary("bluey", 10, 5);
		 animal[1] = new Canary("red", 5, 4);
		 animal[2] = new Canary("yellow", 2, 5);
		 animal[3] = new NorwegianBlue("JohnCleese", 2, 5);
		 animal[4] = new NorwegianBlue("MichaelPalin", 4, 5);
		 animal[5] = new lion("biggy" , 20, 5);
		 animal[6] = new lion("smally" , 26, 2);
		 animal[7] = new Ruck("Ogre" , 6, 34);
		 animal[8] = new Ruck("Troll" , 2, 63);
	
		 int rand = (int)(Math.random()*8);
		 int rand1 = (int)(Math.random()*8);
		 
		 System.out.println("animal 1 is :"+ animal[rand]);
		 System.out.println("animal 2 is " + animal[rand1]);
		 
		 
		 //works , cant figure out how to just print out the string
		 
		
		if ( animal[rand].eats(animal[rand1])){
			System.out.println("winner is the first animal " + animal[rand]); 
			//if first animal wins
			
			
		 }else{
			 //if second animal wins
			 System.out.println("winner is the second animal " + animal[rand1]); 
			 
		 }

		
		
	}

}
