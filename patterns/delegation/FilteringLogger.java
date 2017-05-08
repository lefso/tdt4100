package patterns.delegation;

import java.util.ArrayList;

public class FilteringLogger implements ILogger {
	
	ArrayList<String> isLogging = new ArrayList<>();
	ILogger logger;
	
	public FilteringLogger(ILogger logger, String... severities) {
		this.logger = logger;
		for (String severity : severities) {
			isLogging.add(severity);
		}
	}
	
	public boolean isLogging(String severity) {
		return isLogging.contains(severity);
	}
	
	public void setIsLogging(String severity, boolean value) {
		if (value && !isLogging.contains(severity)) {
			isLogging.add(severity);
		} else if (isLogging.contains(severity)) {
			isLogging.remove(severity);
		}
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		if (this.isLogging(severity)) {
			logger.log(severity, message, exception);
		}
	}

}
