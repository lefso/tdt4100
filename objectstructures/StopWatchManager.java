package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {

	
	Map<String, StopWatch> stopWatches = new HashMap<>();
	
	public StopWatch newStopWatch(String name) {
		StopWatch watch = new StopWatch();
		stopWatches.put(name, watch);
		return watch;
	}
	
	public void removeStopWatch(String name) {
		if (stopWatches.containsKey(name)) {
			stopWatches.remove(name);
		}
	}
	
	public void tick(int ticks) {
		this.getStopWatches().forEach((key, value) -> value.tick(ticks));
	}
	
	public StopWatch getStopWatch(String name) {
		return stopWatches.get(name);
	}
	
	public Collection<StopWatch> getAllWatches() {
		Collection<StopWatch> allWatches = new ArrayList<>();
		
		this.getStopWatches().forEach((String key, StopWatch value) -> allWatches.add(value));
		return allWatches;
	}
	
	public Map<String, StopWatch> getStopWatches() {
		return this.stopWatches;
	}
	
	public Collection<StopWatch> getStartedWatches() {
		Collection<StopWatch> startedWatches = new ArrayList<>();
		
		this.getStopWatches().forEach((String key, StopWatch value) -> {
			if (value.isStarted()) {
				startedWatches.add(value);
			}
		});
		return startedWatches;
	}
	
	public Collection<StopWatch> getStoppedWatches() {
		Collection<StopWatch> stoppedWatches = new ArrayList<>();
		
		this.getStopWatches().forEach((key, value) -> {
			if (value.isStopped()) {
				stoppedWatches.add(value);
			}
		});
		return stoppedWatches;
	}
}
