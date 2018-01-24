package br.com.mystudies.java.functional;

public class APeekIntoTheDefaultMethod {

	public static void main(String[] args) {

		SeaPlane seaPlane = new APeekIntoTheDefaultMethod().seaPlane();
		seaPlane.takeOff();
		seaPlane.turn();
		seaPlane.cruise();
		seaPlane.land();
	}
	
	
	
	
	public SeaPlane seaPlane() {
		return new SeaPlane();
	}
	
	
	
	
	class SeaPlane extends Vehicle implements FastFly, Sail{
		
		private int altitude;	
		/* 
		 * the compiler will force implement the cruise() method, 
		 * because the default implementations in the interfaces FastFly, and Sail conflict
		*/
		public void cruise() {
			System.out.print("SeaPlane::cruise currently cruise like: ");
			
			if(altitude > 0)
				FastFly.super.cruise();
			else
				Sail.super.cruise();
		}	
	}

	

	
	public interface FastFly extends Fly {
		default void takeOff(){System.out.println("FastFly::takeOff");}
	}
	
	
	public interface Sail {
		default void cruise(){System.out.println("Sail::cruise");}
		default void turn(){System.out.println("Sail::turn");}
	}
	
	public interface Fly {
		default void takeOff(){System.out.println("Fly::takeOff");}
		default void land(){System.out.println("Fly::land");}
		default void turn(){System.out.println("Fly::turn");}
		default void cruise(){System.out.println("Fly::cruise");}
	}
	
	public class Vehicle {
		public void turn(){System.out.println("Vehicle::turn");}
	}

}


