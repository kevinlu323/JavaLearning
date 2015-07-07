package com.linkui.socket;

import java.io.*;
import java.net.*;

public class TestSocketServer {
	public static void main(String[] args){
		InputStream is = null;
		OutputStream os = null;
		try{
			ServerSocket ss = new ServerSocket(5888);
			Socket socket = ss.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			String s =null;
			if((s=dis.readUTF())!= null){
				System.out.println(s);
				System.out.println("From " +socket.getInetAddress());
				System.out.println("Port "+socket.getPort());
			}
			dos.writeUTF("Hi, Hello!");
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("Something error with Server");
		}
	}
}
