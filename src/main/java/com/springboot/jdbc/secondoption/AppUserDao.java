package com.springboot.jdbc.secondoption;

import java.util.List;

import com.springboot.jdbc.firstoption.AppUser;

public interface AppUserDao {

	public List<AppUser> getAllAppUsers();

	public AppUser findeAppUserById(Long id);

	public void addAppUser(AppUser appUser);

	public void updateAppUser(AppUser appUser);

	public void deleteAppUser(Long id);
}