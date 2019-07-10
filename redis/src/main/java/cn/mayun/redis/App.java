package cn.mayun.redis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LogDemo.error("error log", null);
        LogDemo.info("info log");
        LogDemo.debug("debug log");
        LogDemo.gameLog("splog.log", "sp log");
    }
}
