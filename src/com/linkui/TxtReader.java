package com.linkui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TxtReader {

	/**
	 * @param args 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "C:\\Users\\linkui\\Desktop\\BatchFiles\\knowledge acquired.txt";
		File fileName = new File(filePath);
		InputStreamReader isr = new InputStreamReader (new FileInputStream(fileName),"UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String line = new String("");

		while ((line = br.readLine()) != null){
			//line = br.readLine();
			System.out.println("显示"+line);
		}
	}

}
