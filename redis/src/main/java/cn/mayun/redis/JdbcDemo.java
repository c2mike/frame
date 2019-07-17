package cn.mayun.redis;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo
{
    public void test() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/example";
        String name = "root";
        String password = "mayun123";
        Connection con = null;
        Statement sta = null;
        ResultSet res = null;
        DatabaseMetaData metaData = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, name, password);
        metaData = con.getMetaData();
        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = "orders";
        String types = null;
        res = metaData.getPrimaryKeys(catalog, schemaPattern, tableNamePattern);
        while(res.next())
        {
            System.out.println(res.getString(4));
            
        }
    }

    public int test2(int[] array)
    {
         int begin = 0;
       int end = array.length-1;
       int mid = (begin+end)/2;
       if(array.length==0)
       {
           return 0;
       } 
       if(end==0)
       {
           return array[0];
       }
       while(begin!=end-1)
       {
           if(array[begin]<array[mid])
           {
               begin = mid;
           }
           if(array[begin]>array[mid])
           {
               end = mid;
           }
           if(array[begin]==array[mid])
           {
               while((mid<array.length) && (array[begin]==array[mid]))
               {
                   mid++;
               }
               
           }
           mid = (begin+end)/2;
       }
        return array[end];
    }
}