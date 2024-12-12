package com.javatpoint.server.main.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class User 
{
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String dob;
private String addr;

//default constructor	
public User()
{
	
}

public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}
public void setId(int id) {
	this.id = id;
}

public Integer getId() 
{
return id;
}
public void setId(Integer id) 
{
this.id = id;
}
public String getName() 
{
return name;
}
public void setName(String name) 
{
this.name = name;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public User(int id, String name, String dob, String addr) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
	this.addr = addr;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", dob=" + dob + ", addr=" + addr + "]";
}
}
