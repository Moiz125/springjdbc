package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entities.Person;

public interface PersonDao {
	
	public int insert(Person person);
	public int change(Person person);
	public int delete(int age);
	public Person getPerson(int age);
	public List<Person> getAllPersons();
}
