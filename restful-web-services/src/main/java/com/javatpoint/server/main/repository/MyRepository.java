package com.javatpoint.server.main.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.server.main.model.User;



@Repository	
public interface MyRepository extends JpaRepository<User, Integer>{

	List<User> findUserByAddr(String address);

}
