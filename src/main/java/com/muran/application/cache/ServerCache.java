package com.muran.application.cache;

import com.alibaba.fastjson.JSON;
import com.muran.application.SpringContextHolder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Steven on 5/3/16.
 * 服务器缓存区域. 每次服务器停止的时候,把缓存写进数据库
 * 服务器加载的时候,读出来所有的缓存
 */
public class ServerCache {

    private ServerCache() {
    }

    private static final ServerCache cache = new ServerCache();

    public static final ServerCache getCache() {
        return cache;
    }

    private Map<String, Object> map = new HashMap<String,Object>();

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
       return map.get(key);
    }

    public Integer getInteger(String key) {
        String value = (String)get(key);
        if (value != null) return Integer.parseInt(value);
        return 0;
    }

    public Float getFloat(String key) {
        String value = (String)get(key);
        if (value != null) return Float.parseFloat(value);
        return 0.0f;
    }

    public Map<String,Object> getAllKeyValues(){
        return map;
    }


    public void persistCache() {
        DriverManagerDataSource dataSource = SpringContextHolder.getBean("dataSource");
        try {
            Connection conn = dataSource.getConnection();
            Statement ps = conn.createStatement();
            ps.addBatch("DROP TABLE IF EXISTS sys_CACHE;");
            ps.addBatch("CREATE TABLE sys_CACHE(" +
                    "cacheKey  varchar(45) NOT NULL primary key," +
                    "cacheContent VARCHAR(10240) NOT NULL," +
                    "classname VARCHAR(45) NOT NULL," +
                    "list  BIT NOT NULL" +
                    ") ; ");
            for (String key : map.keySet()) {
                Object o = map.get(key);
                if (o == null) continue;
                String value = JSON.toJSONString(o);
                int list = 0;
                String classname = o.getClass().getName();
                if (o instanceof List) {
                    list = 1;
                    classname = ((List) o).get(0).getClass().getName();
                }
                ps.addBatch("INSERT INTO sys_CACHE " +
                        "VALUES('" + key + "','" + value + "','" + classname + "'," + list + "); ");
            }
            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadCache() {
        try {//首次启动的时候,不存在表.
            String sql = "select * from sys_cache";
            Session session = ((SessionFactory) SpringContextHolder.getBean("sessionFactory")).openSession();
            Query query = session.createSQLQuery(sql.toString());
            List list = query.list();
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                Object[] objects = (Object[]) iterator.next();
                try {
                    Class clazz = Class.forName((String) objects[2]);
                    if ((Boolean) objects[3]) {
                        map.put((String) objects[0], JSON.parseArray((String) objects[1], clazz));
                    } else {
                        map.put((String) objects[0], JSON.parseObject((String) objects[1], clazz));
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    continue;
                }
            }
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
