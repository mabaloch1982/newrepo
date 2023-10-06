package com.eazybytes.config;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class CustomerJDBCUserDetails extends JdbcUserDetailsManager {

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return super.loadUsersByUsername(username);
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		super.createUser(user);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		super.deleteUser(username);
	}

	
}
