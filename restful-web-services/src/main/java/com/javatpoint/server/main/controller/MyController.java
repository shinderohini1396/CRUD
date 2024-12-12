package com.javatpoint.server.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.server.main.model.User;
import com.javatpoint.server.main.service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService service;
	
	@PostMapping(value = "/save")
	public User add(@RequestBody User u)
	{		
		return	service.add(u);
	}
	
	@GetMapping(value = "/getAllData")
	public List<User> getData()
	{
		List<User> list=service.getAllData();
		return list;
	}
	
	@GetMapping(value = "/getUserByAddress/{address}")
	public List<User> findUserByAddress(@PathVariable String address)
	{
		List<User> u=service.findUserByAddress(address);
		return u;
	}
	
	@GetMapping(value = "/getsingledata/{id}")
	public Optional<User> getSingleData(@PathVariable int id)
	{
		Optional<User> u=service.GetSingleData(id);
		return u;
	}
	
	@PatchMapping(value = "/updaterecord/{id}")
	public String updateData(@PathVariable int id,@RequestBody User u)
	{
		service.add(u);
		return "Update Record";
	}
	
	@DeleteMapping(value = "/deletedata/{id}")
	public String deleteData(@PathVariable int id)
	{
		service.deleteData(id);
		return "Delete Record";
		
	}
}
