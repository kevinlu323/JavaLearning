package com.linkui.socket;

import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception{
		ServerSocket ss = new ServerSocket(6666);
		System.out.println("Starting Server!");
		while(true){
			Socket s = ss.accept();
			System.out.println("A client connect!");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF()); //readUFT is a blocked method. 
			dis.close();
			s.close();
		}
	}
}
