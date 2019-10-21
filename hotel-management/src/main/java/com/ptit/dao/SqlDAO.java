package com.ptit.dao;

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
}
