package com.study.springcore.case08;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonDB { //Json資料庫
	@Autowired
	private Gson gson;
	
	//Json File 資料庫存放
	private static final Path PATH = Paths.get("src/main/java/com/study/springcore/case08/person.json");

	// 查詢全部
	public List<Person> queryAll() throws Exception{
		String jsonStr = Files.readAllLines(PATH).stream().collect(Collectors.joining());
		Type type = new TypeToken<ArrayList<Person>>() {}.getType();
		List<Person> people = gson.fromJson(jsonStr, type);
		//請將age 變為最新年齡
		/*
			Date today = new Date();
			LocalDate todayLocalDate = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			for(Person person : people) {
				LocalDate birthLocalDate = person.getBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				int age = todayLocalDate.getYear() - birthLocalDate.getYear();
				person.setAge(age);
			}
		*/
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		int todayYear = calendar.get(Calendar.YEAR);
		for(Person person :people) {
			calendar.setTime(today);
			calendar.setTime(person.getBirth());
			int birthYear = calendar.get(Calendar.YEAR);
			int age = todayYear - birthYear;
			person.setAge(age);
		}
		return people;
	}
	
	public boolean add(Person person) throws Exception{
		//作業 如果person已存在 則return false
		//name,age,birth 皆與目前資料庫的person相同
			List<Person> people = queryAll();
			people.add(person);
			String newJsonString = gson.toJson(people);
			Files.write(PATH, newJsonString.getBytes("UTF-8"));
			return true;
	}
}
