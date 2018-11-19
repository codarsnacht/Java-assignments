/**
 * 
 */

/**
 * @author Joe Gleeson
 *
 */
public class main {

	
	public static void main(String[] args) {
		//task is to print out all odd numbers between 1 & 100
		System.out.println("Printing all odd numbers between 1 - 100");
		for (int i=1; i<=100; i++){
			//if i modulo 2 is equal to 1, -> odd number and thus printed
			//if i modulo 2 equal to 0 -> even number and not printed
			if(i % 2 == 1){
				System.out.println(i);
			}
		}
	}

}
