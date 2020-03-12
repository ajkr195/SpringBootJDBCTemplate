package com.springboot.jdbc.secondoption;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.jdbc.firstoption.AppUser;

public class AppUserRowMapper implements RowMapper<AppUser> {

	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		AppUser appUser = new AppUser();
		appUser.setId(rs.getLong("id"));
		appUser.setUsername(rs.getString("username"));
		appUser.setPassword(rs.getString("password"));
		appUser.setUseremail(rs.getString("useremail"));
		appUser.setUserfirstname(rs.getString("userfirstname"));
		appUser.setUserlastname(rs.getString("userlastname"));
		appUser.setUseraddress(rs.getString("useraddress"));
		return appUser;
	}

}
