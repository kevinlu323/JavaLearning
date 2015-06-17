package com.linkui;

public class Teacher extends Person{
	private String capital;
	
	Teacher(String name, String capital){
		this(name, "Beijing", capital);
	}
	
	Teacher(String n, String l, String capital){
		super(n,l);
		this.capital=capital;
	}
	
	public String info(){
		return super.info()+" capital: "+capital;
	}

}
