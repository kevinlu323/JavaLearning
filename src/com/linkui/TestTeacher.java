package com.linkui;

public class TestTeacher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person("A");
		Person p2 = new Person("B","Shanghai");
		Student s1 = new Student("C","S1");
		Student s2 = new Student("C","Shanghai","S2");
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(s1.info());
		System.out.println(s2.info());
		
		Teacher t1 = new Teacher("D", "Professor");
		System.out.println(t1.info());
		System.out.println("info"+t1);
	}

}
