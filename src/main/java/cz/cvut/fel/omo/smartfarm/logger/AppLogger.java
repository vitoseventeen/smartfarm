package cz.cvut.fel.omo.smartfarm.logger;

import cz.cvut.fel.omo.smartfarm.strategy.logger.CombinedLogStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.logger.ConsoleLogStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.logger.FileLogStrategy;
import cz.cvut.fel.omo.smartfarm.strategy.logger.LogStrategy;

import java.util.List;
import java.util.Scanner;

public class AppLogger implements ILogger {
    private static AppLogger instance;
    private final LogStrategy logStrategy;
    private static final String logsPath = "src/main/resources/logs";

    private AppLogger(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
    }

    private AppLogger() {
        this.logStrategy = new CombinedLogStrategy(List.of(
                new ConsoleLogStrategy(),
                new FileLogStrategy(logsPath)
        ));
    }

    @Override
    public void log(LogLevel level, String message, StackTraceElement[] stackTrace) {
        this.logStrategy.log(message, level, stackTrace);
    }

    public static AppLogger getInstance() {
        if (instance == null) {
            throw new IllegalStateException("AppLogger is not set up. Call setUpAppLogger() first.");
        }
        return instance;
    }

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