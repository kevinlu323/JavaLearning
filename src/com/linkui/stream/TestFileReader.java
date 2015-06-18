package com.linkui.stream;

import java.io.*;
public class TestFileReader {
	public static void main(String[] args){
		FileReader fr=null;
		int c=0;
		try{
			fr = new FileReader(
					"/home/linkui/workspace/JavaLearning/src/com/linkui/stream/TestFileInputStream.java");
			int ln =0;
			while((c=fr.read())!=-1){
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e1){
			System.out.println("File is not found");
			System.exit(-1);
		} catch (IOException e2){
			System.out.println("Error while reading file");
			System.exit(-1);
		}
	}
}
