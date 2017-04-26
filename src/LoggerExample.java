import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Tania on 26.04.2017.
 */
public class LoggerExample {

    /**
     * Slf4j logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LoggerExample.class.getSimpleName());

    public static void main(String[] args) {
        logger.debug("debug msg");
        logger.info("info msg");
        logger.error("error msg");
    }
}
