package com.javatpoint.server.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javatpoint.server.main.model.User;
import com.javatpoint.server.main.repository.MyRepository;

@Service
public class MyService {

	@Autowired
	private MyRepository repo;

	public User add(User u) {
	return	repo.save(u);
		
	}

	public List<User> getAllData() {
		
		List<User> Userlist= repo.findAll();
		System.out.println("Getteing data from DB: "+Userlist);
		return Userlist;
	}

	public void deleteData(int id) {
		repo.deleteById(id);
		
	}

	public Optional<User> GetSingleData(int id) {
		
		return repo.findById(id);
	}

	public List<User> findUserByAddress(String address) {
		
		return repo.findUserByAddr(address);
	}

	
	
	
		
	
	
}
