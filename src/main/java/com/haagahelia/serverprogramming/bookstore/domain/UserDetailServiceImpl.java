package com.haagahelia.serverprogramming.bookstore.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired 
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = repository.findByUsername(username);
		UserDetails user= new org.springframework.security.core.userdetails.User(username,curruser.getPasswordHash(), AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	
	}
	

}
