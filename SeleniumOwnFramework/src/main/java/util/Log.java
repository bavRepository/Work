package util;

import org.apache.logging.log4j.Logger;

public abstract class Log {

    private static Logger logger = org.apache.logging.log4j.LogManager.getLogger();

    public static void infoLogger(String log) {
        logger.info(log);
    }

    public static void warningLogger(String log) {
        logger.warn(log);
    }

    public static void errorLogger(String log) {
        logger.error(log);
    }
}
