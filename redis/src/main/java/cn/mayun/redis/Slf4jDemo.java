package cn.mayun.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jDemo
{
    private static final Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);
    public static void test()
    {
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("xxx {} {}", "d1", "d2");
        System.out.println("123");
    }
}