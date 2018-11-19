package week6;



public class Ruck extends Tank {
	protected int armour = 0;
	protected int defense = 0;
	protected String name= "";
	
	public Ruck(String name, int armour, int defense) {
		this.defense = defense;
		this.armour=armour;
		this.name = name;
	}
	
	@Override
	public boolean equals (Object obj){
		//check to make sure object is not pointing at null
		if (obj==null){ 
			return false;
		}
		// check to make sure obj is a ruck object
		if (!(obj instanceof Ruck)){ 
			return false;
		}
		// Now we have to *cast* obj to a ruck object
		Ruck r = (Ruck)obj;

		//test for equality
		if(this.armour==r.armour && this.defense==r.defense ){
			return true;
		}
		return false;
	}
	

	@Override
	public void move(int length) {
		move(length);
		
	}

	@Override
	public boolean eats(Animal animal) {
		//eats bird not lions , wins against predators, looses against birds
		// if against itself , looses
		if (animal instanceof lion){
			return true;
		}
		return false;
	}

	
	
	
	
	
	
}
