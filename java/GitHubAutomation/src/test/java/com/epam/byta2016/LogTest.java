package com.epam.byta2016;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by Vitali_Shulha on 12-Feb-16.
 */
public class LogTest {

    @Test
    public void oneCanWriteMessagesToLog(){
        Logger logger = LogManager.getRootLogger();

        logger.debug("Debug message");
        logger.info("Info message");
        logger.error("Error message");
        logger.fatal("Fatal message");
        logger.warn("Warn message");
        logger.trace("Trace message");
    }
}
