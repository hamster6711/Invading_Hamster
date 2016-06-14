/**
 * TODO: Background is currently moving toward left, in speed of 2 pixels
 */
package game.startingClass;

import game.constants.Constants;

public class Background {
	private int bgX, bgY, speedX;

	/**
	 * @param bgX
	 * @param bgY
	 */
	public Background(int bgX, int bgY) {
		this.bgX = bgX;
		this.bgY = bgY;
		speedX = -1;
	}

	// image dimension is 1000*480
	public void update() {
		bgX += speedX;
		
		if(bgX <= -Constants.BG_WIDTH){
			bgX += 2 * Constants.BG_WIDTH;
		}
	}

	public int getBgX() {
		return bgX;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
}
