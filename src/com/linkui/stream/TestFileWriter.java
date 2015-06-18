package com.linkui.stream;

import java.io.*;
public class TestFileWriter {
	public static void main(String[] args){
		FileReader fr =null;
		FileWriter fw=null;
		int c=0;
		try{
			fr = new FileReader(
					"/home/linkui/workspace/JavaLearning/src/com/linkui/stream/TestFileWriter.java");
			fw = new FileWriter("/home/linkui/testfile.java");
			while((c=fr.read())!=-1){
				fw.write(c);
			}
			fr.close();
			fw.close();
		} catch (IOException e){
			System.out.println("Error while writing file");
			System.exit(-1);
		}
		System.out.println("Successfully writed file");
	}
}
