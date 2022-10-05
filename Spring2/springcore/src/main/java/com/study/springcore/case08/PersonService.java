package com.study.springcore.case08;

import java.util.Date;
import java.util.List;

public interface PersonService {
	boolean append(Person person);
	List<Person> findAllPersons();
	boolean append(String name, Date birth);
	boolean append(String name, int birth);
}
