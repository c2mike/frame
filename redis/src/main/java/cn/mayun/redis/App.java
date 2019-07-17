package cn.mayun.redis;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        JdbcDemo demo = new JdbcDemo();
        try {
            int[] arr = {2,2,1,1};
            int ret = demo.test2(arr);
            System.out.println(ret);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
