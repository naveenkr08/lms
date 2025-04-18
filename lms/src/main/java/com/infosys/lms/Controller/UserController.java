package com.infosys.lms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.lms.entity.User;
import com.infosys.lms.responsestructure.ResponseStructure;
import com.infosys.lms.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController  {
	
    @Autowired
    private UserService service;
	
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseStructure<List<User>> findAllUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<User> findUserById(@PathVariable int id){
		return service.findAllUserById(id);
		
	}
		
	@DeleteMapping("/{id}")
	public ResponseStructure<String> deleteUserById(@PathVariable int id){
		return service.deleteById(id);
	}
		
	@PatchMapping("/{id}/{name}")
	public ResponseStructure<User> updateName(int id, String name ){
		
		
		
		
	}

}
