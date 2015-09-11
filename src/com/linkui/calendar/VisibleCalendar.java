package com.linkui.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisibleCalendar {
	public static void main(String[] args){
		System.out.println("Please input date, following the format : MM/dd/yyyy:");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String tmp = "2016-6-14";
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = format.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE, 1);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
		int maxDays = calendar.getActualMaximum(Calendar.DATE);
		System.out.println(maxDays);
		
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		int j = 0;
		//print spaces
		for (int i = 1; i < dayOfWeek; i++){
			System.out.print("\t");
			j++;
		}
		//print days
		for(int i = 1; i <= maxDays; i++){
			if(i == currentDay){
				System.out.print("*");
			}
			System.out.print(i + "\t");
			j++;
			if(j % 7 == 0) System.out.println();
		}
	}
}
