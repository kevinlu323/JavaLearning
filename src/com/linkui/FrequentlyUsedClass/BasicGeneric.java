package com.linkui.FrequentlyUsedClass;

//ÖÐÎÄ×¢½â
import java.util.*;

public class BasicGeneric {
	public static void main(String[] args){
		List<String> l1 = new ArrayList<String>();
		l1.add("aaa");
		l1.add("bbb"); 
		l1.add("ccc");
		
		for (int i=0;i<l1.size();i++){
			String s = l1.get(i);
			System.out.println(s);
		}
		
		Collection<String> c2 = new HashSet<String>();
		c2.add("ddd");
		c2.add("eee");
		c2.add("fff");
		for(Iterator<String> it=c2.iterator();it.hasNext();){
			String s =it.next();
			System.out.println(s);
		}
	}
}
