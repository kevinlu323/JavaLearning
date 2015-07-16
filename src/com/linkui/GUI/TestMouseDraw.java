package com.linkui.GUI;

import java.awt.*;
import java.awt.event.*;

public class TestMouseDraw {
	public static void main(String[] args){
		new DrawFrame("My Frame");
	}
}

class DrawFrame extends Frame{
	Point startPoint= new Point(0,0);
	Point endPoint = new Point(0,0);
	public DrawFrame(String s){
		super(s);
		setLayout(null);
		setBounds(300,300,400,300);
		setBackground(new Color(204,204,255));
		addMouseListener(new DrawMonitor());
		setVisible(true);
	}
	
	public void paint(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		//g.fillRect(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
		g.fillOval(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
		g.setColor(c);
	}
	
	class DrawMonitor extends MouseAdapter{
		public void mousePressed(MouseEvent e1){
			startPoint = new Point(e1.getX(),e1.getY());
			//System.out.println("Point: "+ e1.getX() +e1.getY());
		}
		public void mouseReleased(MouseEvent e2){
			endPoint = new Point(e2.getX(),e2.getY());
			//System.out.println("Point: "+ e2.getX() +e2.getY());
			DrawFrame.this.repaint();
		}
		/*public void mouseExited(MouseEvent e3){
			DrawFrame.this.setBackground(Color.BLACK);
		}
		public void mouseEntered(MouseEvent e3){
			DrawFrame.this.setBackground(new Color(204,204,255));
		}*/
	}
}