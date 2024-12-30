package cz.cvut.fel.omo.smartfarm.strategy.logger;

import cz.cvut.fel.omo.smartfarm.logger.ILogger;

import java.io.PrintStream;
import java.time.LocalDateTime;


public class ConsoleLogStrategy implements LogStrategy {
    @Override
    public void log(String message, ILogger.LogLevel level, StackTraceElement[] stackTrace) {
        String logMessage = String.format("[%s] [%s] %s", LocalDateTime.now(), level, message);

        PrintStream stream = (level == ILogger.LogLevel.ERROR) ? System.err : System.out;

        logToStream(stream, logMessage, stackTrace);
    }

    private void logToStream(PrintStream stream, String message, StackTraceElement[] stackTrace) {
        stream.println(message);

        if (stackTrace != null) {
            for (StackTraceElement element : stackTrace) {
                stream.println("\tat " + element);
            }
        }
    }
}
