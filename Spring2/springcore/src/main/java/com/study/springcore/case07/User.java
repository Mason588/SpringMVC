package com.study.springcore.case07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//在 applicationContext7.xml配置文件中有設定
//<context:include-filter type="assignable" expression="com.study.springcore.case07.User"/>
//可不用加註@Component
//@Component
public class User {
	@Value(value="John")
	private String name;
	@Value(value="18")
	private Integer age;
	
	@Value("#{${nicknames:{'Happy','Enjoy'}}}") //Spring EL
	private String[] nicknames;
	
	@Value("#{${subjects:{'Chinese','Englis','Math'}}}") //Spring EL
	private Set<String> subjects;
	@Value("#{${scores:{'100','100','100'}}}") //Spring EL
	private List<Integer> scores;
	@Value("#{${hobbits:{1:'Play ball',2:'Music'}}}") //Spring EL
	private Map<Integer, String> hobbits;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String[] getNicknames() {
		return nicknames;
	}
	public void setNicknames(String[] nicknames) {
		this.nicknames = nicknames;
	}
	public Set<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public Map<Integer, String> getHobbits() {
		return hobbits;
	}
	public void setHobbits(Map<Integer, String> hobbits) {
		this.hobbits = hobbits;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", nicknames=" + Arrays.toString(nicknames) + ", subjects="
				+ subjects + ", scores=" + scores + ", hobbits=" + hobbits + "]";
	}
	
	
}