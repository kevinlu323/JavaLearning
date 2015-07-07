package com.linkui.socket;

import java.io.*;
import java.net.*;

public class TestSocketClient {
	public static void main(String[] args){
		InputStream in = null;
		OutputStream out = null;
		try{
			Socket socket = new Socket("127.0.0.1",5888);
			in = socket.getInputStream();
			out = socket .getOutputStream();
			DataInputStream dis = new DataInputStream(in);
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF("Hey!");
			String s = null;
			/*while((s=dis.readUTF())!=null){
				System.out.println("Message from Server: "+ s);
			}*/
			if((s=dis.readUTF())!=null){
				System.out.println("Message from Server: "+ s);
			}
			dos.close();
			dis.close();
			socket.close();
		} catch (UnknownHostException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
