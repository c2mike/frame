package cn.mayun.redis;

import java.util.HashMap;
import java.util.Map;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.Response;

public class RedisDemo {

    public void test2()
    {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
    }
    public void test() {
        JedisPool conns = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379, Protocol.DEFAULT_TIMEOUT, null);
        Jedis conn = null;
        conn = conns.getResource();

        Pipeline p = conn.pipelined();
        p.sadd("searched#","pairs");
        Response<Boolean> exist = p.sismember("searched#", "ppairs");
        p.sync();
        System.out.println(exist.get());        
        //key
        /*System.out.println("key is exist:"+conn.exists("name"));
        conn.set("name", "zhumajie");
        System.out.println("key is exist:"+conn.exists("name"));
        System.out.println("value:"+conn.get("name"));
        System.out.println("type:"+conn.type("name"));
        System.out.println("time to live:"+conn.ttl("name"));
        conn.expire("name", 10);
        System.out.println("time to live:"+conn.ttl("name"));
        System.out.println("return of persist:"+conn.persist("name"));
        conn.set("name", "new zhubajie");
        System.out.println("value:"+conn.get("name"));
        conn.del("name");
        */
        /*
        conn.set("mykey", "zhubajie");
        System.out.println("mukey:"+conn.get("mykey"));
        long ret = conn.setnx("mykey", "newzhubajie");
        String val = conn.setex("mykey",10, "new newzhubajie");
        conn.set("mykey2","8");
        ret = conn.incrBy("mykey2",10);
        ret = conn.decrBy("mykey2",10);
        System.out.println(ret);
        */
        
        /*
        Map<String,String> hash = new HashMap<String,String>();
        hash.put("name", "zhubajie");
        hash.put("age", "18");
        hash.put("honny", "eat");
        String  ret = conn.hmset("demohash", hash);
        System.out.println(ret);
        long val=conn.hset("demohash", "name", "newzhubajie");
        System.out.println(val);
        val = conn.hsetnx("demohash", "name", "newnewzhubajie");
        System.out.println(val);
        ret = conn.hget("demohash", "name");
        System.out.println(ret);
        System.out.println(conn.hgetAll("demohash").toString());
        System.out.println(hash.toString());
        conn.hdel("demohash", "name");
        System.out.println(conn.hgetAll("demohash").toString());
        */

        /*
        long len = conn.lpush("listDemo2","one ");       
        conn.lpush("listDemo2", "two");
        System.out.println(conn.lrange("listDemo2", 0, -1).toString());
        */

        /*
        long size=conn.sadd("setDemo", "one","two,","three");
        System.out.println(size);
        System.out.println(conn.srem("setDemo", "one","two","three"));
        System.out.println(conn.smembers("setDemo").toString());
        System.out.println(conn.sismember("setDemo", "two,"));
        conn.sadd("setDemo", "one","three");
        System.out.println(conn.scard("setDemo"));
        conns.destroy();
        */
    }

    public void test3()
    {
        Jedis redis = new Jedis("127.0.0.1",6379);
        Map<String,String> data = new HashMap<String,String>();
        redis.select(1);
        redis.flushDB();
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++)
        {
            data.clear();
            data.put("k_"+i, "v"+i);
            redis.hmset("key_", data);

        }
        long end = System.currentTimeMillis();
        System.out.println("dbsize:["+redis.dbSize()+"]..");
        System.out.println("hmset without pipeline use:["+(end-start)/1000+"]");

        redis.flushDB();
        Pipeline p = redis.pipelined();
        start = System.currentTimeMillis();
        for(int i=0;i<10000;i++)
        {
            data.clear();
            data.put("k_"+i, "v_"+i);
            p.hmset("key_", data);
        }
        p.sync();
        end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
        redis.flushDB();
        
    }

    public void reOrderArray(int [] array) {
        for(int i = 0;i<array.length-1;++i)
        {
            for(int j = i;j<array.length-1;j++)
            {
                if(array[j]%2==0&&array[j+1]%2==1)
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


}