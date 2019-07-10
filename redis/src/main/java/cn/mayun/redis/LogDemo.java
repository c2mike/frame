package cn.mayun.redis;

import java.io.File;
import java.util.HashMap;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.RollingFileAppender;

public class LogDemo {

    static {

        String root = System.getProperty("user.dir") + File.separator + "redis" + File.separator;
        PropertyConfigurator.configure(root + "config" + File.separator + "log4j.properties");
    }

    private static Logger infoLogger = Logger.getLogger("infoLogger");
    private static Logger errorLogger = Logger.getLogger("errorLogger");
    private static Logger debugLogger = Logger.getLogger("debugLogger");

    //public static HashMap<String,Logger> gameLogger = new HashMap<String,Logger>();

    public static void debug(String msg)
    {
        debugLogger.debug(msg);
    }

    public static void error(String msg, Throwable e)
    {
        errorLogger.error(msg, e);
    }

    public static void info(String msg)
    {
        infoLogger.info(msg);
    }
    

 public static Logger getLoggerByName(String file)
    {
        Logger logger = Logger.getLogger(file);
        logger.removeAllAppenders();
        logger.setLevel(Level.INFO);
        logger.setAdditivity(false);

        FileAppender appender = new RollingFileAppender();
        PatternLayout layout = new PatternLayout();

        String conversionPattern = "%d{yyyy-MM-dd HH:mm:ss SSS}  [ %-6t ] - [ %p ]  %m%n";
        layout.setConversionPattern(conversionPattern);

        appender.setLayout(layout);
        appender.setFile(file);
        appender.setEncoding("UTF-8"); 
        appender.setImmediateFlush(true);
        appender.setAppend(true);
        appender.activateOptions(); 
        logger.addAppender(appender);
        return logger;
    }  
    
    public static void gameLog(String file, String msg)
    {
        getLoggerByName(file).info(msg);
    }
}