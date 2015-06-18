package com.linkui.stream;

import java.io.*;
public class TestBufferStream1 {
	public static void main(String[] args){
		FileInputStream fis=null;
		BufferedInputStream bis = null;
		try{
			fis = new FileInputStream(
					"/home/linkui/workspace/JavaLearning/src/com/linkui/stream/TestFileInputStream.java");
			bis = new BufferedInputStream(fis);
			int c = 0;
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.mark(100);
			for (int i=0;i<=10&&(c=bis.read())!=-1;i++){
				System.out.print((char)c+ " ");
			}
			System.out.println();
			bis.reset();
			for(int i = 0; i<=10 && (c=bis.read())!=-1;i++){
				System.out.print((char)c+ " ");
			}
			bis.close();
		} catch (IOException e){
			System.out.println("Error while reading file");
		}
	}
}
