/**
 * Coin is treated as circle, it uses the center to position
 * 
 */

package game.coins;

import java.awt.Point;

public abstract class Coin {
	private int value;
	private Point center;
	private double radius;
	
	/**
	 * @param value
	 * @param center
	 * @param radius
	 */
	public Coin(Point center) {
		this.center = center;
	}

	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
