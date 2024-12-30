package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

public interface LogStrategy {
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace);
}
