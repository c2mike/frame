package cn.mayun.redis;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBDemo {
    private DataSource dataSource;
    private static final Logger logger = LoggerFactory.getLogger(DBDemo.class);

    public DBDemo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setSqlArgs(PreparedStatement sql, Object... args) throws Exception{
        int i = 1;
        if (args != null) {
            for (Object it : args) {
                if (it.getClass() == Integer.class) {
                    sql.setInt(i++, (int) it);
                    continue;
                }
                if(it.getClass() == Long.class)
                {
                    sql.setLong(i++, (long) it);
                    continue;
                }
                if(it.getClass()==Float.class)
                {
                    sql.setFloat(i++, (float) it);
                    continue;

                }
                if(it.getClass()==Double.class)
                {
                    sql.setDouble(i++, (double) it);
                    continue;
                }
                if(it.getClass()==String.class)
                {
                    sql.setString(i++, (String)it);
                    continue;
                }
                throw new Exception("sql type error");
            }
        }
    }
}