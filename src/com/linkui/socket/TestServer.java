package com.linkui.socket;

import java.net.*;
import java.io.*;

public class TestServer {
	public static void main(String[] args){
		try{
			ServerSocket ss = new ServerSocket(8888);
			while(true){
				Socket s1 = ss.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				dos.writeUTF("Hello "+s1.getInetAddress()+" port # "+s1.getPort()+" bye bye!");
				dos.close();
				s1.close();
			}
		} catch (IOException e){
			e.printStackTrace();
			System.out.println("Something error with server");
		}
	}
}
