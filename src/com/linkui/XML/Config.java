package com.linkui.XML;

public class Config {
	public String server;
	public String user;
	public String pass;
	public String port;
	public String dbname;

	public String getConnString() {

		String connString = "jdbc:mysql://" + server + ":" + port + "/" + dbname + 
				"?user=" + user + "&password=" + pass
				+ "&useUnicode=true&characterEncoding=UTF-8";
		return connString;

	}
}
