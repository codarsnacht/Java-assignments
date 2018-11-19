package casino;

import java.util.ArrayList;

public class Stack<B> extends ArrayList<B> {
	private static final long serialVersionUID = 2373516189973616245L;

	
	public void push ( B elm){
		this.add( elm);
	}
	
	public B pop(){
		if ( this.size() > 0){
			B elm = this.get(0);
			this.remove(0);
			return elm;
		}
		
		return null; 
		
		
	}
	
	
	
}
