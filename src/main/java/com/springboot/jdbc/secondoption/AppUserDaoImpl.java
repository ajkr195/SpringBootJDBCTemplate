package com.springboot.jdbc.secondoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jdbc.firstoption.AppUser;

@Transactional
@Repository
public class AppUserDaoImpl implements AppUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<AppUser> getAllAppUsers() {
		String query = "SELECT * from appuser";
		RowMapper<AppUser> rowMapper = new AppUserRowMapper();
		List<AppUser> list = jdbcTemplate.query(query, rowMapper);

		return list;
	}

	@Override
	public AppUser findeAppUserById(Long id) {
		String query = "SELECT * FROM appuser WHERE id = ?";
		RowMapper<AppUser> rowMapper = new BeanPropertyRowMapper<AppUser>(AppUser.class);
		AppUser appUser = jdbcTemplate.queryForObject(query, rowMapper, id);

		return appUser;
	}

	@Override
	public void addAppUser(AppUser appUser) {
		String query = "INSERT INTO appuser(id, username, password, useremail, userfirstname, userlastname, useraddress) VALUES(?, ?, ?, ?, ?, ?,?)";
		jdbcTemplate.update(query, appUser.getId(),appUser.getPassword(), appUser.getUsername(), appUser.getUseremail(),
				appUser.getUserfirstname(), appUser.getUserlastname(), appUser.getUseraddress());

	}

	@Override
	public void updateAppUser(AppUser appUser) {
		String query = "UPDATE appuser SET username=?, password=?, useremail=?, userfirstname=?, userlastname=?, useraddress=? WHERE id=?";
		jdbcTemplate.update(query, appUser.getUsername(), appUser.getPassword(), appUser.getUseremail(),
				appUser.getUserfirstname(), appUser.getUserlastname(), appUser.getUseraddress(), appUser.getId());

	}

	@Override
	public void deleteAppUser(Long id) {
		String query = "DELETE FROM appuser WHERE id=?";
		jdbcTemplate.update(query, id);
	}

}
