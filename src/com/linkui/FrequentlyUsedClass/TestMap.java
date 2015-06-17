package com.linkui.FrequentlyUsedClass;

import java.util.*;

public class TestMap {
	public static void main(String[] args){
		Map m1 = new HashMap();
		Map m2 = new TreeMap();
		m1.put("one", 1);
		m1.put("two", 2);
		m1.put("three", new Integer(3));
		m2.put("A", 323);
		System.out.println(m1.size());
		System.out.println(m1.containsKey("two"));
		System.out.println(m1.containsValue(4));
		
		if(m1.containsKey("two")){
			int i =(Integer)m1.get("two");
			System.out.println(i);
		}
		Map m3 = new HashMap(m1);
		m3.putAll(m2);
		System.out.println(m3);
	}

}
