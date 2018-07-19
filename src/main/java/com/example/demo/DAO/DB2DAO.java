package com.example.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Bean.DB2Bean;

@Repository
public class DB2DAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<DB2Bean> getAllNAICSNames() {
		String sql = "SELECT NAICS_ID, NAICS_NM from SCOUT.NAICS";
		RowMapper<DB2Bean> rowMapper = new BeanPropertyRowMapper<DB2Bean>(DB2Bean.class);
		return jdbcTemplate.query(sql, rowMapper);

	}

	public DB2Bean getNAICSNameByID(int ID) {
		String sql = "SELECT NAICS_ID, NAICS_NM from SCOUT.NAICS Where NAICS_ID = ?";
		RowMapper<DB2Bean> rowMapper = new BeanPropertyRowMapper<DB2Bean>(DB2Bean.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, new Integer(ID));

	}
}

/*
 * SELECT NAICS_NM from SCOUT.NAICS Where NAICS_ID = 441110
 */
