package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

import java.util.ArrayList;
import java.util.List;

public class CombinedLogStrategy implements LogStrategy {
    private final List<LogStrategy> strategies = new ArrayList<>();

    public CombinedLogStrategy(List<LogStrategy> strategies) {
        this.strategies.addAll(strategies);
    }


    @Override
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace) {
        for (LogStrategy strategy : strategies) {
            strategy.log(message, level, stackTrace);
        }
    }
}
