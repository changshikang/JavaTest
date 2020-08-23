package logfj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4JTest {
   // private static final Logger LOGGER=Logger.getLogger(Log4JTest.class);//不推荐使用
    //使用slf4j里面的api来获取日志对象
    private static Logger LOGGER= LoggerFactory.getLogger(Log4JTest.class);

    public static void main(String[] args) {
        LOGGER.debug("debug");
        LOGGER.info("info");
        LOGGER.warn("warn");
        LOGGER.error("error");
    }
}
