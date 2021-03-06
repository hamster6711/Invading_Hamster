package game.constants;

import game.poop.Poop;

public class Constants {
	/** Background image */
	public static final int BG_WIDTH = 1300;
	public static final int BG_HEIGHT = 480;
	
	/** Canvas constants */
	public static final int CANVAS_WIDTH = 800;
	public static final int CANVAS_HEIGHT = 480;
	public static final int PADDING = 5;

	/** Life coordinate */
	public static final int L_X = 45;
	public static final int L_Y = 38;
	
	public static final int LIFE1_X = 655;
	public static final int LIFE2_X = 700;
	public static final int LIFE3_X = 745;
	public static final int LIFE_Y = 5;
		
	
	/** Threshold constants */
	// hamster
	public static final double ATTACK_WIDTH_RATIO = 0.13;
	public static final double ATTACK_TOP_RATIO = 0.13;
	public static final double ATTACK_BOTTOM_RATIO = 0.85;
	public static final int HAM_GEN_LBOUND = 150;
	// avoid range
	public static final double AVOID_WIDTH_RATIO = 0.10;
	public static final double AVOID_TOP_RATIO = 0.08;
	public static final double AVOID_BOTTOM_RATIO = 0.50;
	// coin -- to be edited
	public static final double COIN_TOP_THRESHOLD = 3.5;
	public static final double COIN_BOTTOM_THRESHOLD_RATIO = 0.13;
	public static final double COIN_WIDTH_THRESHOLD_RATIO = 0.67;
	
	/** constants for hamster */
	public static final int MISSED_HAM_Y = 1000;
	// hamster minion
	public static final int HAMSTER_MINION_SPEED = 2;
	public static final int HAMSTER_MINION_FLEE_SPEED = -2;
	public static final int HAMSTER_MINION_WIDTH = 55;
	public static final int HAMSTER_MINION_HEIGHT = 47;
	
	/** constants for straw-man */
	public static final int STRAW_MAN_WIDTH = 69;
	public static final int STRAW_MAN_HEIGHT = 380;
	public static final int STRAW_MAN_SCALED_HEIGHT = 100;

	/** constants for poop */
	public static final Poop DEFAULT_POOP = new Poop(-1000, -1000);
	public static final Poop HIT_POOP = new Poop(1000, 1000);
	public static final int POOP_LOWER_BOUND = 220; // minimum height to drop poop
	public static final int POOP_SPEED = 1;
	public static final int POOP_WIDTH = 34;
	public static final int POOP_HEIGHT = 30;
	// ratio to locate poop's x coordinate according to hamster's width
	public static final double POOP_HAM_RATIO = 0.25; 

	/** constants for coins -- to be edited */
	public static final int SMALL_COIN_VALUE = 5;
	public static final double SMALL_COIN_RADIUS = 1.0;
	public static final int LARGE_COIN_VALUE = 10;
	public static final double LARGE_COIN_RADIUS = 2.0;
}
