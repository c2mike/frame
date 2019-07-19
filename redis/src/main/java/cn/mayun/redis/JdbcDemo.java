package cn.mayun.redis;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.ResultSetMetaData;

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

        sta = con.createStatement();
        String sql = "select * from orders";
        res = sta.executeQuery(sql);
        ResultSetMetaData struct = res.getMetaData();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<struct.getColumnCount();i++)
        {
         builder.append(struct.getColumnLabel(i+1)).append(" ");     
        }
        System.out.println(builder.toString());
        res.close();       
        sta.close();
        con.close();
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
                       
           }
           mid = (begin+end)/2;
       }
        return array[end];
    }


    public void test3()
    {
        int i = 0;
        while(i<100000)
        {
            if(i==99999)
            {
                i = 0;
            }
            i++;
        }
    }

    public int getbit(int n)
    {
         int count=0;
        while(n!=0)
        {
            n=n&n-1;
            count++;
        }
        return count;
    }
}