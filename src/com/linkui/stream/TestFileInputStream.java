package com.linkui.stream;

import java.io.*;
public class TestFileInputStream {
	public static void main (String[] args){
		int b =0;
		FileInputStream in = null;
		try{
			in = new FileInputStream(
					"/home/linkui/workspace/JavaLearning/src/com/linkui/stream/TestFileInputStream.java");
		} catch (FileNotFoundException e){
			System.out.println("Cannot find file");
			System.exit(-1);
		}
		
		try{
			long num = 0;
			while((b=in.read())!=-1){
				System.out.print((char)b);
				num++;
			}
			in.close();
			System.out.println();
			System.out.println("Read " + num + " bytes in total.");
		} catch (IOException e){
			System.out.println("Error while reading file");
			System.exit(-1);
		}
	}

}
