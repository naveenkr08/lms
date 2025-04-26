package org.jsp.dre.service;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

import org.jsp.dre.dao.UserDao;
import org.jsp.dre.dto.MatchingUser;
import org.jsp.dre.entity.User;
import org.jsp.dre.responsestructure.ResponseStructure;
import org.jsp.dre.util.SortByAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private EmailService emailService;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User savedUser = dao.saveUser(user);
		
		ResponseStructure<User> rs = ResponseStructure.<User>builder()
				.status(HttpStatus.OK.value())
				.message("User is saved Successfully!")
				.body(savedUser)
				.build();
		
		return new ResponseEntity<>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		List<User> findAll = dao.findAll();
		
		ResponseStructure<List<User>> rs= ResponseStructure.<List<User>>builder()
				.status(HttpStatus.OK.value())
				.message("Get ALL users")
				.body(findAll)
				.build();
		
		return new ResponseEntity<>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
	      Optional<User> optional = dao.findUserById(id);
	      
	      if(optional.isEmpty()) {
	    	  ResponseStructure<User> rs = ResponseStructure.<User>builder()
	    			  .status(HttpStatus.OK.value())
	    			  .message("Id has found")
	    			  .body(optional.get())
	    			  .build();
	    	  
	    	  return new ResponseEntity<>(rs,HttpStatus.OK);
	      }
	      else {
	    	  ResponseStructure<User> rs = ResponseStructure.<User>builder()
	    			  .status(HttpStatus.OK.value())
	    			  .message("Id Not found")
	    			  .body(null)
	    			  .build();
	    	  
	    	  return new ResponseEntity<>(rs,HttpStatus.NOT_FOUND);
	    			  
	      }
	      
	}

	public ResponseEntity<?> findMatch(int id, int top) {
		
	 Optional<User> optional=dao.findUserById(id);
	 
	 if(optional.isEmpty()) {
		 throw new RuntimeException("Invalid User id, unable to find top matches");
	 }
	 
	 
	 User user = optional.get();
	 
	 String gf = null;
	 if(user.getGender().equalsIgnoreCase("MALE"))
	 {
		 gf= "FEMALE";
	 }
	 else {
		 gf = "MALE";
	 }
	 
	List<User> users= dao.findByGender(gf);
	
   List<MatchingUser> matchingUser = new ArrayList<>();
   
   for(User u: users) {
	   MatchingUser mu = new MatchingUser();
	   
	   mu.setId(u.getId());
	   mu.setName(u.getName());
	   mu.setEmail(u.getEmail());
	   mu.setPhone(u.getPhone());
	   mu.setPassword(u.getPassword());
	   mu.setAge(u.getAge());
	   mu.setIntrests(u.getIntrests());
	   mu.setGender(u.getGender());
	   
	   int ad = user.getAge();
	   int aad = Math.abs(ad);
	   
	   mu.setAgeDifference(aad);
	   
	   int mic = 0;
	   List<String> intrests1= user.getIntrests();
	   
	   List<String> intrests2 = u.getIntrests();
	   
	   for(String i : intrests1) {
		   if(intrests2.contains(i)) {
			   mic++;
		   }
		   
	   }
	   mu.setMatchingIntrestCount(mic);
	   matchingUser.add(mu);
	   
   }
   
   
   
           Collections.sort(matchingUser, new SortByAge());
           int c = 0;
           
           List<MatchingUser> result = new ArrayList<>();
           
           for(MatchingUser mu: matchingUser) {
        	   if(top==0) {
        		   break;
        		   
        	   }else {
        		   result.add(mu);
        		   top--;
        	   }
           }
           
           ResponseStructure<List<MatchingUser>> rs = ResponseStructure.<List<MatchingUser>>builder()
                   .status(HttpStatus.OK.value())
                   .message("Sorted Matching Users")
                   .body(result)
                   .build();

           return new ResponseEntity<>(rs, HttpStatus.OK);
	
	      
	     
	}
	
}
