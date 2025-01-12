package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the LogStrategy interface and allows combining multiple logging strategies.
 * It iterates through a list of strategies and delegates the logging operation to each of them.
 */
public class CombinedLogStrategy implements LogStrategy {

    // A list to store multiple logging strategies
    private final List<LogStrategy> strategies = new ArrayList<>();

    /**
     * Constructor that initializes the CombinedLogStrategy with a list of LogStrategy instances.
     *
     * @param strategies A list of LogStrategy instances that will be used for logging.
     */
    public CombinedLogStrategy(List<LogStrategy> strategies) {
        this.strategies.addAll(strategies);
    }

    /**
     * Logs a message using all the strategies in the list.
     * Each strategy is called in sequence to handle the log message.
     *
     * @param message    The message to be logged.
     * @param level      The log level indicating the severity or importance of the message.
     * @param stackTrace The stack trace associated with the log message.
     */
    @Override
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace) {
        // Iterate over each logging strategy and delegate the log operation
        for (LogStrategy strategy : strategies) {
            strategy.log(message, level, stackTrace);
        }
    }
}
