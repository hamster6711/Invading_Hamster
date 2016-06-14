package game.coins;

import java.awt.Point;

import game.constants.Constants;

public class SmallCoin extends Coin {

	public SmallCoin(Point center) {
		super(center);
		this.setValue(Constants.SMALL_COIN_VALUE);
		this.setRadius(Constants.SMALL_COIN_RADIUS);
	}
}
