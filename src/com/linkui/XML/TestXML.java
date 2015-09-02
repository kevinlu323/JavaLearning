package com.linkui.XML;

public class TestXML {
	public static void main(String[] args){
		Config conf = new Config();
		conf = XMLReader.loadconfig();
		System.out.println(conf.getConnString());
	}
}
