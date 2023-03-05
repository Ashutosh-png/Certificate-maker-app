package com.workshop.service;

import org.springframework.stereotype.Service;

import com.workshop.entity.User;
import com.workshop.repository.Repository;
@Service
public class UserServiceImpl implements Userservice{
	
	private Repository repo;
	
	public UserServiceImpl (Repository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}
	
	public Iterable<User> showAll() {
		return repo.findAll();
	}
	
	public void deleteall() {
		repo.deleteAll();
	}

}
