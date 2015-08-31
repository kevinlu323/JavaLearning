package com.linkui.basic;

import java.util.Calendar;

public class TestCalendar {
	public static void main(String[] args){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		System.out.println(c.getTime());
	}
}
