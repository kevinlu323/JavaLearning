package com.linkui.stream;

import java.io.*;
public class TestPrintStream2 {
	public static void main (String[] args){
		String filename = "C:\\Users\\Linkui\\Desktop\\testfile.txt";
		if(filename!=null){
			list(filename,System.out);
		}
	}
	
	public static void list(String f, PrintStream fs){
		try{
			BufferedReader br = new BufferedReader (new FileReader(f));
			String s = null;
			while ((s=br.readLine())!=null){
				fs.println(s);
			}
			br.close();
		}catch (IOException e){
			e.printStackTrace();
			System.out.println("Error while reading file");
		}
	}
}
