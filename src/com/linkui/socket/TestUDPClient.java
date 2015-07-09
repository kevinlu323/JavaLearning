package com.linkui.socket;

import java.io.*;
import java.net.*;

public class TestUDPClient {
	public static void main(String[] args) throws Exception{
		long n = 10000L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		byte[] buf = baos.toByteArray();
		System.out.println(buf.length);
		//byte[] buf = (new String("Hello")).getBytes();
		DatagramPacket dp = new DatagramPacket(buf,buf.length,
				new InetSocketAddress("127.0.0.1",5678));
		DatagramSocket ds = new DatagramSocket(9999);
		ds.send(dp);
		ds.close();
	}
}
