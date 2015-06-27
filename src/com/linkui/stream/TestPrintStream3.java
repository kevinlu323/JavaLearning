package com.linkui.stream;

import java.io.*;
import java.util.*;
public class TestPrintStream3 {
	public static void main(String[] args){
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			FileWriter fw = new FileWriter("C:\\Users\\Linkui\\Desktop\\testfile1.txt",true);
			PrintWriter log =new PrintWriter(fw);
			while((s=br.readLine())!=null){
				if (s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
				log.println("----------");
				log.println(s.toUpperCase());
				log.flush();
			}
			log.println("==="+new Date()+"===");
			log.flush();
			log.close();
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("error while writing file");
		}
	}
}
