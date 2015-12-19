package com.linkui.FrequentlyUsedClass;

import java.util.*;

public class TestArgsWord {
	public static void main (String[] args){
		if (args.length==0){
			System.out.println("No parameter is entered.");
			System.exit(0);
		}
		Map m = new HashMap();
		for(int i=0;i<args.length;i++){
			int freq = m.get(args[i])==null? 0:((Integer)m.get(args[i]));
			m.put(args[i], (freq == 0? 1:freq+1));
		}
		
		System.out.println(m.size()+" unique parameters found");
		System.out.println(m);
		
	}

}
