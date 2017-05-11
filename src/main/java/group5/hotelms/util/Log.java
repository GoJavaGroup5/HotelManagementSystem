package group5.hotelms.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrey Ponomarenko
 */
public class Log {

    private static final Logger logger = LoggerFactory.getLogger(Log.class.getSimpleName());

    /**
     * log an error message
     *
     * @param o - Object to be logged
     */
    public static void error(Object o) {
        logger.error("errror ", o);
    }

    /**
     * log an debug message
     *
     * @param o - Object to be logged
     */
    public static void debug(Object o) {
        logger.debug("debug ", o);
    }

    /**
     * log an info message
     *
     * @param o - Object to be logged
     */
    public static void info(Object o) {
        logger.info("info ", o);
    }

}
