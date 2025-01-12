package cz.cvut.fel.omo.smartfarm.logger;

import cz.cvut.fel.omo.smartfarm.strategy.logger.CombinedLogStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.logger.ConsoleLogStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.logger.FileLogStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.logger.LogStrategy;

import java.util.List;
import java.util.Scanner;

/**
 * Singleton class for application logging.
 * Allows configuration of logging strategies that include console logging, file logging, or a combination of both.
 */
public class AppLogger implements ILogger {
    private static AppLogger instance;
    private final LogStrategy logStrategy;
    private static final String logsPath = "src/main/resources/logs";

    /**
     * Private constructor for AppLogger using a specific LogStrategy.
     * @param logStrategy The logging strategy to be used by this logger.
     */
    private AppLogger(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
    }

    /**
     * Default private constructor that sets a combined logging strategy (both console and file).
     */
    private AppLogger() {
        this.logStrategy = new CombinedLogStrategy(List.of(
                new ConsoleLogStrategy(),
                new FileLogStrategy(logsPath)
        ));
    }

    /**
     * Logs a message along with its level and stack trace using the configured LogStrategy.
     * @param level The severity level of the log.
     * @param message The message to be logged.
     * @param stackTrace The stack trace elements associated with the log.
     */
    @Override
    public void log(LogLevel level, String message, StackTraceElement[] stackTrace) {
        this.logStrategy.log(message, level, stackTrace);
    }

    /**
     * Provides the singleton instance of AppLogger.
     * @return The singleton instance of AppLogger.
     * @throws IllegalStateException if the AppLogger has not yet been set up with a LogStrategy.
     */
    public static AppLogger getInstance() {
        if (instance == null) {
            throw new IllegalStateException("AppLogger is not set up. Call setUpAppLogger() first.");
        }
        return instance;
    }

    /**
     * Initializes the AppLogger with a LogStrategy selected by the user input.
     * Prompts the user to choose between console logging, file logging, or combined logging.
     */
    public static void setUpAppLogger() {
        Scanner scanner = new Scanner(System.in);
        LogStrategy selectedStrategy = null;

        while (selectedStrategy == null) {
            try {
                System.out.println("Choose a logging strategy:");
                System.out.println("1. Console Logging");
                System.out.println("2. File Logging");
                System.out.println("3. Combined Logging");

                int choice = Integer.parseInt(scanner.nextLine().trim());

                selectedStrategy = switch (choice) {
                    case 1 -> new ConsoleLogStrategy();
                    case 2 -> new FileLogStrategy(logsPath);
                    case 3 -> new CombinedLogStrategy(List.of(
                            new ConsoleLogStrategy(),
                            new FileLogStrategy(logsPath)
                    ));
                    default -> {
                        System.out.println("Invalid choice. Please enter a valid number (1, 2, or 3).\n");
                        yield null;
                    }
                };
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).\n");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage() + "\nPlease try again.\n");
            }
        }

        instance = new AppLogger(selectedStrategy);
        System.out.println("Logging strategy set up successfully.");
    }
}
