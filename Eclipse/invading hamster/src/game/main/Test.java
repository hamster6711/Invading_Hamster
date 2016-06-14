
package game.main;

import game.hamsters.Hamster;
import game.hamsters.HamsterMinion;
import game.strawman.StrawMan;

public class Test {
	public static void main(String args[]) {
		// strawman leftX at (0, 330), rightX at (100, 330)
		StrawMan st = StrawMan.getInstance();
		
		// create two hamsters with bottom left coordinate at (80, 332)
		Hamster a = new HamsterMinion(80,332);
		//Thread.sleep(1000);
		//HamsterMinion b = new HamsterMinion(bPos);
		System.out.println(a);
		//System.out.println(b);
		System.out.println(a.isHit());
	}

		/**
	    public static void main(String args[]) {

	        // This is the first block of code
	        Thread thread = new Thread() {
	            public void run() {
	                for (int i = 0; i < 10; i += 2) {
	                    System.out.println("hello this is thread one");
	                }
	            }

	        };

	        // This is the second block of code
	        Thread threadTwo = new Thread() {
	            public void run() {
	                for (int i = 0; i < 10; i += 2) {
	                    System.out.println("hello this is thread two");
	                }
	            }

	        };

	        // These two statements are in the main method and begin the two
	        // threads.
	        // This is the third block of code
	        thread.start();

	        // This is the fourth block of code
	        threadTwo.start();
	    }
	    
	    **/

} 
