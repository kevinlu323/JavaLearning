package com.linkui.GUI;

import java.awt.*;

public class TestFrame {
	public static void main(String[] args){
		Frame f = new Frame("This is my first test");
		f.setLocation(300,300);
		f.setSize(170, 100);
		f.setBackground(Color.blue);
		f.setResizable(true);
		f.setVisible(true);
	}
}
