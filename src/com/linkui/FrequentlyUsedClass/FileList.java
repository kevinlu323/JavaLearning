package com.linkui.FrequentlyUsedClass;

import java.io.*;

public class FileList {
	public static void main(String[] args){
		File f = new File ("C:/Development/TESTINGapp");
		System.out.println(f.getName());
		tree(f,1);
	}
	
	private static void tree(File f, int level){
		String preStr= "";
		for (int i=0;i<level;i++){
			preStr+="    ";
		}
		File[] children = f.listFiles();
		for (int i=0;i<children.length;i++){
			System.out.println(preStr+children[i].getName());
			if(children[i].isDirectory()){
				tree(children[i],level+1);
			}
		}
	}
}
