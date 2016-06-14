package game.startingClass;

import java.util.Timer;
import java.util.TimerTask;

public class hamTimer {
	Timer timer;

	public hamTimer(int seconds) {
		timer = new Timer();
		timer.schedule(new HamTask(), seconds * 1000);
	}

	class HamTask extends TimerTask {
		public void run() {
			System.out.println("Time's up!");
			timer.cancel(); // Terminate the timer thread
		}
	}
}
