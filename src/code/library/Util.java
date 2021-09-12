package code.library;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Util {
	
	private Util() {
		throw new IllegalStateException("Utility class");
	}

	public static Logger getLogger(String loggerName) {
		Logger logger = Logger.getLogger(loggerName);
		
		MessageOnlyFormatter formatter = new MessageOnlyFormatter();
		logger.setUseParentHandlers(false);
		
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(formatter);
		logger.addHandler(consoleHandler);
		return logger;
	}
}

class MessageOnlyFormatter extends Formatter {
	
	@Override
	public String format(LogRecord rec) {
		//rec.get
		return rec.getLevel() + ": " + formatMessage(rec) + "\n";
	}
}
