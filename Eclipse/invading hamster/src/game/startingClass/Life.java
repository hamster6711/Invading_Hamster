package game.startingClass;

import java.awt.Image;
import game.constants.Constants;

public class Life {
	private int x;
	private int y = Constants.LIFE_Y;
//	private Image display = alive;
//	private Image alive = getImage(base, "data/life/straw_alive.png");
	private Image dead;
	
	private Life() {
	}

	private static class LifeHolder {
		private static final Life LIFE1 = new Life();
		private static final Life LIFE2 = new Life();
		private static final Life LIFE3 = new Life();
	}

	public void update(int gameCount){
		if(gameCount == 3){
			
		}
	}
	
	private void setX(int x) {
		this.x = x;
	}
	
	public static Life getLife1() {
		LifeHolder.LIFE1.setX(Constants.LIFE1_X);
		return LifeHolder.LIFE1;
	}
	
	public static Life getLife2() {
		LifeHolder.LIFE2.setX(Constants.LIFE2_X);
		return LifeHolder.LIFE2;
	}
	
	public static Life getLife3() {
		LifeHolder.LIFE3.setX(Constants.LIFE3_X);
		return LifeHolder.LIFE3;
	}

	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	
}