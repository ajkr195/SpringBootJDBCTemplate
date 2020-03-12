package com.springboot.jdbc.secondoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jdbc.firstoption.AppUser;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	 private AppUserDaoImpl employeeDao;

	@Override
	public List<AppUser> getAllAppUsers() {
		return employeeDao.getAllAppUsers();
	}

	@Override
	public AppUser findeAppUserById(Long id) {
		return employeeDao.findeAppUserById(id);
	}

	@Override
	public void addAppUser(AppUser appUser) {
		employeeDao.addAppUser(appUser);
	}

	@Override
	public void updateAppUser(AppUser appUser) {
		employeeDao.updateAppUser(appUser);
	}

	@Override
	public void deleteAppUser(Long id) {
		employeeDao.deleteAppUser(id);
	}

}
