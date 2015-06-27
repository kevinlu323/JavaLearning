package com.linkui.stream;

import java.io.*;

public class TestTransform1 {
	public static void main(String[] args){
		try{
			//OutputStreamWriter can write String directly
			OutputStreamWriter osw = new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\Linkui\\Desktop\\testfile.txt"));
			osw.write("This is OutputStreamWriter test file!!");
			System.out.println(osw.getEncoding());
			osw.close();
			osw = new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\Linkui\\Desktop\\testfile.txt",true),"ISO8859_1");// true means add to original file
			//ISO8859_1 - Latin-1 
			osw.write("This is OutputStreamWriter test file!!");
			System.out.println(osw.getEncoding());
			osw.close();
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("Error while writing files");
		}
	}
}
