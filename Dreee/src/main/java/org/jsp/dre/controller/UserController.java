package org.jsp.dre.controller;

import java.util.List;

import org.jsp.dre.entity.User;
import org.jsp.dre.responsestructure.ResponseStructure;
import org.jsp.dre.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id){
		return service.findUserById(id);
	}
	
	@GetMapping("/match/{id}/{top}")
	public ResponseEntity<?> findMatch(@PathVariable int id, @PathVariable int top){
		return service.findMatch(id,top);
	}
	
    @GetMapping("/search/{name}")
    public ResponseEntity<?> search(@PathVariable String name){
    	return service.search(name);
    }
	
	
	
	
	
	
	

}
