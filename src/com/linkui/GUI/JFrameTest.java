package com.linkui.GUI;

import java.awt.*;
import javax.swing.*;

public class JFrameTest {
	public static void main(String[] args) {
		new MyJFrame();
	}
}

class MyJFrame extends JFrame {
	private final int wid = 600;
	private final int hei = 400;
	private Point pos = null;
	private Image buffer = null;
	public MyJFrame() {
		pos = new Point(0,0);
		setSize(wid,hei);
		setVisible(true);
		new Thread(new Move()).start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		Color temp = g.getColor();
		g.setColor(Color.BLUE);
		g.fillOval(pos.x,pos.y,50,50);
		g.setColor(temp);
	}
	public void update(Graphics g) {
		if (buffer == null) {
			buffer = this.createImage(wid,hei);
		}
		Graphics bg = buffer.getGraphics();
		bg.setColor(Color.PINK);
		bg.fillRect(0,0,wid,hei);
		paint(bg);
		g.drawImage(buffer,0,0,null);
	}
	private class Move implements Runnable {
		public void run() {
			while(true&&(pos.x+50<=wid&&pos.y+50<=hei)) {
				pos.x++;
				System.out.println(pos.x+" + "+pos.y);
				pos.y++;
				repaint();
				try {
					Thread.sleep(10);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}