package transport;

public class Bikedemo {

	public static void main(String[] args){
		
		bike bike1 = new bike();
		bike bike2 = new bike();
		
		bike1.speed = 10;
		bike2.speed = 10;
		
		bike1.gear = 10;
		bike2.gear = 10;
		
		if(bike1.speed==bike2.speed && bike1.gear==bike2.gear ){
			System.out.println("equal");
			
		}else {
			System.out.println("not equal");
		}
		
	}
	
}
