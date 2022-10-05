package com.study.springcore.case08;
import java.util.List;

import com.study.springcore.case08.Person;

public interface PersonDao {
	//建立Person
	public boolean create();
	//查詢所有Person
	public List<Person> readAll();
	boolean create(Person person);
}
