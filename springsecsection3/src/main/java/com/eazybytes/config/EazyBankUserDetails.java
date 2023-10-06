package com.eazybytes.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.eazybytes.model.Customer;
import com.eazybytes.model.SecurityCustomer;
import com.eazybytes.repository.CustomerRepository;

@Service 
public class EazyBankUserDetails implements UserDetailsManager {//UserDetailsManager,UserDetailsService(if simply need user search by name feature

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> customer = customerRepository.findByEmail(username);
		if (customer.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user : " + username);
		}
		return new SecurityCustomer(customer.get(0));
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		
		System.out.println("UserName: " + username);
		UserDetails userDetails  = loadUserByUsername(username);
		
		return userDetails==null?false:true;
	}

}
