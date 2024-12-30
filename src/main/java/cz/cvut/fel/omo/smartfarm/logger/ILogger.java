package cz.cvut.fel.omo.smartfarm.logger;

public interface ILogger {

    enum LogLevel {
        ERROR,
        WARNING,
        INFO,
        HINT
    }


     void  log(LogLevel level, String message, StackTraceElement[] stackTrace);


    default void log(LogLevel level, String message) {
        log(level, message, null);
    }


    default void logError(String message) {
        log(LogLevel.ERROR, message, null);
    }

    default void logWarning(String message) {
        log(LogLevel.WARNING, message, null);
    }

    default void logInfo(String message) {
        log(LogLevel.INFO, message, null);
    }

    default void logHint(String message) {
        log(LogLevel.HINT, message, null);
    }
}

