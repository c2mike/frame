package cn.mayun.redis;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamDemo
{
    public  void test()
    {
        Integer[] arr = {1,2,3,4,5};
        long count = Stream.of(arr).filter(x->x>2).count();
        System.out.println(count);
    }
}