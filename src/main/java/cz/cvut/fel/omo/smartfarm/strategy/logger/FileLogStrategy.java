package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class implements the LogStrategy interface and defines a strategy for logging messages to a file.
 * It creates a log file with a timestamped filename and writes the log message along with any stack trace to the file.
 */
public class FileLogStrategy implements LogStrategy {

    // The file path where the log will be written
    private final String filePath;

    /**
     * Constructor that initializes the FileLogStrategy with the path to the folder where the log file will be saved.
     * The log file will have a timestamp in its filename to ensure uniqueness.
     *
     * @param folderPath The folder path where the log file will be saved.
     */
    public FileLogStrategy(String folderPath) {

        // Format the current date and time to create a timestamp for the log file name
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);

        // Construct the file path by appending the timestamp and ".log" extension
        this.filePath = folderPath + "/" + timestamp + ".log";
    }

    /**
     * Logs a message to a file with the appropriate log level and timestamp.
     * If a stack trace is provided, it will also be written to the file.
     *
     * @param message    The message to be logged.
     * @param level      The log level indicating the severity of the message.
     * @param stackTrace The stack trace to be written to the file (if available).
     */
    @Override
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace) {
        // Format the log message with the current timestamp and log level
        String logMessage = String.format("[%s] [%s] %s%n", LocalDateTime.now(), level, message);

        // Try to write the log message and stack trace to the log file
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // Write the log message to the file
            writer.write(logMessage);

            // If a stack trace is provided, write each stack trace element to the file
            if (stackTrace != null) {
                for (StackTraceElement element : stackTrace) {
                    writer.write("\tat " + element + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            // Print an error message if writing to the file fails
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}
