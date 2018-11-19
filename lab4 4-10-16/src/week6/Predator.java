package week6;

public abstract class Predator extends Animal {
//idea , pred has strong attack , weak defense , wins against bird but not against tank 
	protected boolean teath = true;
	protected boolean fast = true;
	protected boolean aggressive = true;
	
	
	public abstract void fast(int length);
	
	
}
