package objectstructures;

public class StopWatch {

	private int ticks = 0, time = 0, timeStopped = 0, lapTime = -1, lastLapTime = 0;
	private boolean stopped = false, started = false;

	public int getTicks() {
		return ticks;
	}

	public int getTime() {
		if (started == true && stopped == false) {
			return ticks - time;
		} else if (stopped == true) {
			return timeStopped - time;
		}
		return -1;
	}

	public int getLapTime() {
		return lapTime;
	}

	public int getLastLapTime() {
		if (lastLapTime == 0) {
			return -1;
		}
		return lastLapTime;
	}
	
	public void tick(int ticks) {
		this.ticks += ticks;
		this.lapTime = ticks;
	}
	
	public boolean isStarted() {
		return started;
	}
	
	public boolean isStopped() {
		return stopped;
	}
	
	public void start() {
		started = true;
		time = this.getTicks();
		lapTime = this.getTicks();
		
	}
	
	public void lap() {
		if (lapTime != 0) {
			lastLapTime = lapTime;
		}
		lapTime = 0;
	}
	
	public void stop() {
		if(started) {
			stopped = true;
			timeStopped = this.getTicks();
			this.lap();
		}
//		stopped = true;
//		timeStopped = this.getTicks();
//		this.lap();
	}
	
	public String toString() {
		return this.isStarted() + " / " + this.isStopped();
	}
}
