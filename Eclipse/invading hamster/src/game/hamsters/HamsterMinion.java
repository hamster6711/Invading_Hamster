package game.hamsters;

import game.constants.Constants;

public class HamsterMinion extends Hamster{

	public HamsterMinion(int leftX, int leftY) {
		super(leftX, leftY);
		this.setSpeed(Constants.HAMSTER_MINION_SPEED);
		this.setWidth(Constants.HAMSTER_MINION_WIDTH);
		this.setHeight(Constants.HAMSTER_MINION_HEIGHT);
	}

	@Override
	public void flee() {
		this.setSpeed(Constants.HAMSTER_MINION_FLEE_SPEED);
	} 
}
