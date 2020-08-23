package logfj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4JUnit {
    private static Logger LOGGER= LoggerFactory.getLogger(Log4JTest.class);
    public static void getLog(){
        LOGGER.debug("DEBUG");
        LOGGER.info("INFO");
        LOGGER.warn("WARN");
        LOGGER.error("ERROR");
    }
}
