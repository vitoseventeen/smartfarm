package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

/**
 * This interface defines the strategy for logging messages.
 * Any class implementing this interface must provide a concrete implementation
 * for logging messages with a specified log level and optional stack trace.
 */
public interface LogStrategy {

    /**
     * Logs a message with the specified log level and stack trace.
     *
     * @param message    The message to be logged.
     * @param level      The log level indicating the severity of the message.
     * @param stackTrace The stack trace associated with the log message, if available.
     */
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace);
}
