package org.jsp.dre.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatchingUser  {
	
    private int id;
	
	private String name;
	
	private String email;
	
	private long phone;
	
	private String password;
	
	private String gender;
	
	private int age;
	private List<String> intrests;
	
	private int ageDifference;
	
	private int matchingIntrestCount;

}
