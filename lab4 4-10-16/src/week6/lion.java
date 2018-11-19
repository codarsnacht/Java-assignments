package week6;


	public  class lion extends Predator{

		protected int attack =0;
		protected int defense = 0;
		protected String name= "";


		/**
		 * constructor 1
		 */
		public lion(String name, int attack, int defense) {
			this.defense = defense;
			this.attack=attack;
			this.name = name;
		}
		
		@Override
		public boolean equals (Object obj){
			//check to make sure object is not pointing at null
			if (obj==null){ 
				return false;
			}
			// check to make sure obj is a lion object
			if (!(obj instanceof lion)){ 
				return false;
			}
			// Now we have to *cast* obj to a lion object
			lion l = (lion)obj;

			//test for equality
			if(this.attack==l.attack && this.defense==l.defense ){
				return true;
			}
			return false;
		}
		
		
		
		@Override
		public void fast(int length) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void move(int length) {
			fast(length);
			
		}

		@Override
		public boolean eats(Animal animal) {
			// if lion is against bird , it wins , if against tank , it looses
			// if against lion , it looses
			if ( animal instanceof Bird){
				return true;
			}
			
			
			return false;
		}
	
	
	
	
	
	

}