package com.linkui.socket;

import java.io.*;
import java.net.*;

public class TestClient {
	public static void main(String[] args){
		try{
			Socket s1 = new Socket("127.0.0.1",8888);
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream (is);
			System.out.println(dis.readUTF());
			dis.close();
			s1.close();
		} catch(ConnectException e){
			e.printStackTrace();
			System.out.println("Error while connecting to server");
		}
		catch (IOException e){
			e.printStackTrace();
			System.out.println("Something error in Client");
		}
	}
}
