package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

import java.io.PrintStream;
import java.time.LocalDateTime;

/**
 * This class implements the LogStrategy interface and defines a strategy for logging messages to the console.
 * It logs messages with a timestamp and severity level, and prints the stack trace if provided.
 */
public class ConsoleLogStrategy implements LogStrategy {

    /**
     * Logs a message to the console with the appropriate log level and timestamp.
     * If the log level is ERROR, the message is logged to the error stream (System.err),
     * otherwise it is logged to the standard output stream (System.out).
     *
     * @param message    The message to be logged.
     * @param level      The log level indicating the severity of the message.
     * @param stackTrace The stack trace to be printed (if available).
     */
    @Override
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace) {
        // Format the log message with the current timestamp and log level
        String logMessage = String.format("[%s] [%s] %s", LocalDateTime.now(), level, message);

        // Choose the appropriate print stream based on the log level
        PrintStream stream = (level == ILogger.LogLevel.ERROR) ? System.err : System.out;

        // Log the message and stack trace to the selected stream
        logToStream(stream, logMessage, stackTrace);
    }

    /**
     * Logs the message and stack trace to the provided print stream.
     *
     * @param stream     The print stream (System.out or System.err) to write to.
     * @param message    The message to be logged.
     * @param stackTrace The stack trace to be printed (if available).
     */
    private void logToStream(PrintStream stream, String message, StackTraceElement[] stackTrace) {
        // Print the log message to the stream
        stream.println(message);

        // If a stack trace is provided, print each stack trace element
        if (stackTrace != null) {
            for (StackTraceElement element : stackTrace) {
                stream.println("\tat " + element);
            }
        }
    }
}
