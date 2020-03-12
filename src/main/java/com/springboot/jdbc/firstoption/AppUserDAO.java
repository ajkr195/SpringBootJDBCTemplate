package com.springboot.jdbc.firstoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppUserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<AppUser> list() {
		String sql = "SELECT * FROM appuser";

		List<AppUser> listSale = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(AppUser.class));

		return listSale;
	}

	
	public void save(AppUser appuser) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("appuser").usingColumns("username", "password", "useremail", "userfirstname", "userlastname", "useraddress");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(appuser);
		
		insertActor.execute(param);		
	}
	
	public AppUser get(int id) {
		String sql = "SELECT * FROM appuser WHERE id = ?";
		Object[] args = {id};
		AppUser appuser = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(AppUser.class));
		return appuser;
	}
	
	public void update(AppUser appuser) {
		String sql = "UPDATE appuser SET username=:username, password=:password, useremail=:useremail, userfirstname=:userfirstname, userlastname=:userlastname, useraddress=:useraddress  WHERE id=:id";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(appuser);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM appuser WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
}
