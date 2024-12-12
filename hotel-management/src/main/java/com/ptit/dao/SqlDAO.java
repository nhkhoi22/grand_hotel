package com.ptit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SqlDAO extends JdbcDaoSupport {
	
	@Autowired
    public SqlDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	
	public List<Map<String, Object>> queryForList(String sql) {
		 
        // List<Map<String, Object>> queryForList(String sql)
        List<Map<String, Object>> list = this.getJdbcTemplate().queryForList(sql);
        
        return list;
    }
	
	public boolean insert(String sql){
		Connection connection = null;
        Statement stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/hotel_management", "root", "123456");
             
            stmt = connection.createStatement();
            stmt.execute(sql);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
	}
}
