package com.infosys.lms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.infosys.lms.entity.User;
import com.infosys.lms.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository repo;
	
	public User savedUser(User user) {
		return repo.save(user);
	}

	public List<User> findAllUsers() {
		
		return repo.findAll();
	}

	public Optional<User> findUserById(int id) {
		
		return repo.findById(id);
	}

	public void deleteById(int id) {
		
		 repo.deleteById(id);
		
	}
	
	

}
