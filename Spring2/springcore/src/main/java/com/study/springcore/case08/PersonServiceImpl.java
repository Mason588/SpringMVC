package com.study.springcore.case08;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao personDao;
	
	@Override
	public boolean append(String name, Date birth) {
		Person person = new Person();
		person.setName(name);
		person.setBirth(birth);
		return append(person);
	}

	@Override
	public boolean append(Person person) {
		
		return personDao.create();
	}

	@Override
	public List<Person> findAllPersons() {
		
		return personDao.readAll();
	}

	@Override
	public boolean append(String name, int birth) {
		// TODO Auto-generated method stub
		return false;
	}


}
