package com.infosys.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
