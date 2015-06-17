package com.linkui;

public class Student extends Person{
	private String school;
	Student(String name, String school){
		this(name, "beijing", school);
	}
	Student(String n, String l, String school){
		super(n,l);
		this.school=school;
	}
	
	public String info(){
		return super.info()+" School: "+school;
	}

}
