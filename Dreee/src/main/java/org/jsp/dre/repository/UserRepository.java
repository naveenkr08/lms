package org.jsp.dre.repository;

import java.util.List;

import org.jsp.dre.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByGender(String gf);
	

	
}
