package cz.cvut.fel.omo.smartfarm.logger;

/**
 * Interface for logging various types of messages with different levels of severity.
 * Provides methods for logging messages at standard levels such as error, warning, info, and hint.
 */
public interface ILogger {

    /**
     * Enumeration of log levels used to specify the severity of a log message.
     */
    enum LogLevel {
        ERROR,    // Log level for error messages.
        WARNING,  // Log level for warning messages.
        INFO,     // Log level for informational messages.
        HINT      // Log level for hints or helpful tips.
    }

    /**
     * Logs a message with a specific log level and stack trace.
     *
     * @param level The severity level of the log message.
     * @param message The message to be logged.
     * @param stackTrace An array of StackTraceElement providing the stack trace where the log was called; can be null.
     */
    void log(LogLevel level, String message, StackTraceElement[] stackTrace);

    /**
     * Logs a message with a specific log level without providing a stack trace.
     *
     * @param level The severity level of the log message.
     * @param message The message to be logged.
     */
    default void log(LogLevel level, String message) {
        log(level, message, null);
    }

    /**
     * Convenience method for logging an error message.
     *
     * @param message The error message to be logged.
     */
    default void logError(String message) {
        log(LogLevel.ERROR, message, null);
    }

    /**
     * Convenience method for logging a warning message.
     *
     * @param message The warning message to be logged.
     */
    default void logWarning(String message) {
        log(LogLevel.WARNING, message, null);
    }

    /**
     * Convenience method for logging an informational message.
     *
     * @param message The informational message to be logged.
     */
    default void logInfo(String message) {
        log(LogLevel.INFO, message, null);
    }

    /**
     * Convenience method for logging a hint or tip.
     *
     * @param message The hint or tip to be logged.
     */
    default void logHint(String message) {
        log(LogLevel.HINT, message, null);
    }
}
