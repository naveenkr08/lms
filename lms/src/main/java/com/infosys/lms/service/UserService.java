package com.infosys.lms.service;
//import com.infosys.lms.controller.BookController; 


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.infosys.lms.Controller.BookController;
import com.infosys.lms.dao.UserDao;
import com.infosys.lms.entity.User;
import com.infosys.lms.responsestructure.ResponseStructure;

@Service
public class UserService {


    private final BookController bookController;
    
	@Autowired
    private UserDao dao;

    UserService(BookController bookController) {
        this.bookController = bookController;
    }
  
	public ResponseStructure<User> saveUser(User user) {
		User savedUser = dao.savedUser(user);
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("User saved successfully");
		structure.setBody(savedUser);
		return structure;
	}
		
	public ResponseStructure<List<User>> findAllUsers() {
		List<User> users = dao.findAllUsers();
		// TODO Auto-generated method stub
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("All users found Successfully");
		structure.setBody(users);
		return structure;
		
	}

	 public ResponseStructure<User> findAllUserById(int id) {
		Optional<User> optional = dao.findUserById(id);
		User user = optional.get();
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage(" User found successfully");
		structure.setBody(user);
		return structure;

	}
	 
	 public ResponseStructure<String> deleteById(int id){
		 
		 dao.deleteById(id);
		 
		 ResponseStructure<String> structure = new ResponseStructure<>();
		 structure.setStatus(200);
		 structure.setMessage("User deleted Succesfully");
		 structure.setBody("User Deleted");
		 return structure;
	 }
	 
	 public ResponseStructure<User> updateName(int id, String name) {
		    Optional<User> optional = dao.findUserById(id);
		    if (optional.isEmpty()) {
		        throw new RuntimeException("Invalid user ID!"); 

		    User user = optional.get();
		    user.setName(name); 
		    User updatedUser = dao.savedUser(user); 

		    ResponseStructure<User> structure = new ResponseStructure<>();
		    structure.setStatus(200);
		    structure.setMessage("User name updated successfully");
		    structure.setBody(updatedUser);
		    return structure;
		}

}
