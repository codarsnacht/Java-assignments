package shopping;

public class ShoppingCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer customer = new Customer();
		ShoppingCart cart = new ShoppingCart();
		Bill bill = new Bill();
		
		customer.addCart(cart);
		
		int cost1 = 15;
		int cost2 = 30;
		int cost3 = 10;
	    int cost4 = 20;
		
		Item item1 = new Item( 12345666L);
		item1.setCost(cost1);
		Item item2 = new Item(12345667L);
		item2.setCost(cost2);
		Item item3 = new Item(12345668L);
		item3.setCost(cost3);
		Item item4 = new Item(12345669L);
		item4.setCost(cost4);
		
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
		cart.addItem(item4);
		
		
		int total = cart.getTotal();
		
		int actual = cost1 + cost2 + cost3 + cost4 ;
		
		if(total==actual){
		System.out.println("getTotal is correct");
		System.out.println("item 1 is " + cost1  + "item 2 is "+cost2 + "item 3 is " + cost3 + "item 4 is "+ cost4);
		System.out.println("Total is " + total);
		}else{
		System.out.println("getTotal is wrong");
		System.out.println("expected " + actual);	
		System.out.println("returned " + total);	
		}
		
		System.out.println("removing an item from cart ");
		
		cart.removeItem(item4);
		int newActual = cost1 + cost2 + cost3;
		int newTotal = cart.getTotal();
		if(total==actual){
			System.out.println("getTotal is correct");
			System.out.println("item 1 is " + cost1  + "item 2 is "+cost2 + "item 3 is " + cost3 );
			System.out.println("Total is " + newTotal);
		}else{
			System.out.println("getTotal is wrong");
			System.out.println("expected " + newActual);	
			System.out.println("returned " + newTotal);	
			}
		
		
		bill.inputBill();
		
		
		
		
	}

}
