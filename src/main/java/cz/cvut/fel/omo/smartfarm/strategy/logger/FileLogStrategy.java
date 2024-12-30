package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogStrategy implements LogStrategy {

    private final String filePath;

    public FileLogStrategy(String folderPath) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestamp = LocalDateTime.now().format(formatter);
        this.filePath = folderPath + "/" + timestamp + ".log";

    }



    @Override
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace) {
        String logMessage = String.format("[%s] [%s] %s%n", LocalDateTime.now(), level, message);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(logMessage);

            if (stackTrace != null) {
                for (StackTraceElement element : stackTrace) {
                    writer.write("\tat " + element + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to write log to file: " + e.getMessage());
        }
    }
}