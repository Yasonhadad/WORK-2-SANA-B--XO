package Race;

public class Racer implements Runnable {
	private static int globalId =1;
	private int id;
	private int speed;
	private Track track;

	public Racer(int speed , Track track) {
		if (speed < 1 || speed > 10) {
			throw new IllegalArgumentException("Speed must be between 1 and 10");
		}
		id = globalId;
		globalId++;
		this.track = track;
		this.speed = speed;
	}
	public void go() {
		Thread.currentThread().setPriority(speed);
		for (int i = 1 ;i<=100 ; i++) {
			System.out.println("Runner "+this.id+" run "+i+" metres.");
		}
		track.setfinishedRacers();
		System.out.println("Runner "+this.id+ " finished " +getOrdinal(track.getfinishedRacers()));

	}
	private String getOrdinal(int number) {

		switch (number) {
		case 1:  return number + "st";
		case 2:  return number + "nd";
		case 3:  return number + "rd";
		default: return number + "th";
		}
	}

	@Override
	public void run() {
		go();
	}

}
