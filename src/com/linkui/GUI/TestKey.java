package com.linkui.GUI;

import java.awt.*;
import java.awt.event.*;

public class TestKey {
	public static void main(String[] args){
		new KeyFrame().launchFrame();
	}
}

class KeyFrame extends Frame{
	public void launchFrame(){
		setSize(200,200);
		setLocation(300,300);
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_UP){
					System.out.println("Up");
				}
			}
		});
		setVisible(true);		
		}
	/*
	class MyKeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			//System.out.println("Ok,key pressed"+e.getKeyCode());
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_UP){
				System.out.println("Up");
			}
		}
	}*/
}