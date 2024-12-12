package com.javatpoint.server.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatpoint.server.main.model.User;
import com.javatpoint.server.main.repository.MyRepository;
import com.javatpoint.server.main.service.MyService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RestfulWebServicesApplicationTests {

//	private Calculator c=new Calculator();
	
	@Autowired
	private MyService service;
	
	@MockBean
	private MyRepository repository;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllDataTest()
	{
		when(repository.findAll())
	    .thenReturn(Stream.of(
	        new User(8, "Kiran Shinde", "1999-07-29", "Pune"),
	        new User(1, "Rohini", "1996-08-13", "Pune")
	    ).collect(Collectors.toList()));

		assertEquals(2, service.getAllData().size());
		
	}
	
	@Test
	public void findUserByAddressTest()
	{
	String addr="Hydrabad"	;
	when(repository.findUserByAddr(addr))
    .thenReturn(Stream.of(
        new User(8, "Kiran Shinde", "1999-07-29", "Pune")
    ).collect(Collectors.toList()));
	
	assertEquals(1, service.findUserByAddress(addr).size());
	
	}
	
	@Test
	public void addUser()
	{
		User user=new User(10, "Rupali", "1996-08-13", "Banglore");
		when(repository.save(user)).thenReturn(user);
		
		assertEquals(user, service.add(user));
	
	}
	
	@Test
	public void deleteUserTest()
	{
		User user=new User(1, "Rohini", "1996-08-13", "Pune");
	//	service.deleteData(user);
		verify(repository,times(1)).delete(user);
	}
	
/*	@Test
	public void testSum() {
		//expected
		int expectedResult=10;
		
		//actual
		int actualResult=c.doSum(7, 2, 1);
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	@Test
	public void testProduct()
	{
		//expected
		int expectedResult=6;
		
		//actual
		int actualResult=c.doProduct(3, 2);
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	*/
}
