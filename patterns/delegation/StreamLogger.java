package patterns.delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
	
	OutputStream stream;
	private String formatString = "%s %s %s";
	
	public StreamLogger(OutputStream stream) {
		this.stream = stream;
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		String logMessage = String.format(formatString, severity, message, exception);
		try {
			stream.write(logMessage.getBytes());
			stream.flush();
		} catch (IOException IOE) {
			log(ILogger.ERROR, IOE.getStackTrace().toString(), IOE);
		}
	}
	
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
}
