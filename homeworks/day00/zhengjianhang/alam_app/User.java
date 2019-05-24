package com.alam.app.alam_app;

import javax.jws.soap.SOAPBinding.Use;

//import alam01.alamTest05.User;

public class User {
	private String username;
	private int age;
	private String school;
	
	User(){
	}
	User(String username,int age){
		this.username=username;
		this.age=age;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", school=" + school + "]";
//		return "User [username=" + username + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User alamUser = new User();
		alamUser.setAge(12);
		alamUser.setUsername("alam");
		alamUser.setSchool("schoolAAAA");
		System.out.println(alamUser);
	}

}
