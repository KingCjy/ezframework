package me.kingcjy.ezframework.util;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    @Test
    public void LogTest() {
        Logger logger = Logger.getLogger(LoggerTest.class.getName());

        logger.log(Level.INFO, "logger test {0} a {1}", new Object[]{"12", "34"});
    }
}
