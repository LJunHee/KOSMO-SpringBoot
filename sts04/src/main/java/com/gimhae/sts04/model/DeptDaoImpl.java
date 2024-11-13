package com.gimhae.sts04.model;

import java.lang.System.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<DeptVo> getList(){
		log.debug("dao");
		return jdbcTemplate.query("select * from dept", new RowMapper<DeptVo>() {
			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return DeptVo.builder()
						.deptno(rs.getInt("deptno"))
						.dname(rs.getString("dname"))
						.loc(rs.getString("loc"))
						.build();
			}
		});
	}
}
