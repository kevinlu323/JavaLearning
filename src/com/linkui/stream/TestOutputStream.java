package com.linkui.stream;

import java.io.*;
public class TestOutputStream {
	public static void main(String[] args){
		int b =0;
		FileInputStream in = null;
		FileOutputStream out = null;
		try{
			in =new FileInputStream(
					"/home/linkui/workspace/JavaLearning/src/com/linkui/stream/TestFileInputStream.java");
			out = new FileOutputStream("/home/linkui/testfile.java");
			while((b=in.read())!=-1){
				out.write(b);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e1){
			System.out.println("File is not found");
			System.exit(-1);
		} catch (IOException e2){
			System.out.println("Error while reading/writing file");
			System.exit(-1);
		}
		System.out.println("Successfully copied the file");
	}
}
