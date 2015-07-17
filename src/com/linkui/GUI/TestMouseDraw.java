package com.linkui.GUI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class TestMouseDraw {
	public static void main(String[] args){
		new DrawFrame("My Frame");
	}
}

class DrawFrame extends JFrame{
	Point startPoint= new Point(0,0);
	Point endPoint = new Point(0,0);
	public DrawFrame(String s){
		super(s);
		setLayout(null);
		setBounds(300,300,400,300);
		//setBackground(new Color(204,204,255));
		addMouseListener(new DrawMonitor());
		/*addWindowListener(new WindowAdapter(){ //window listener, exit app when click Close button.
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		//super.paint(g);
		g.setColor(new Color(204,204,255));
		g.fillRect(0, 0, 400, 300);
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		int startX=Math.min(startPoint.x,endPoint.x);
		int startY = Math.min(startPoint.y, endPoint.y);
		int lengthX= Math.abs(endPoint.x-startPoint.x);
		int lengthY = Math.abs(endPoint.y-startPoint.y);
		g.fillRect(startX,startY,lengthX,lengthY);
		//g.fillRect(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
		//g.fillOval(startPoint.x, startPoint.y, endPoint.x-startPoint.x, endPoint.y-startPoint.y);
		g.setColor(c);
	}
	
	class DrawMonitor extends MouseAdapter{
		public void mousePressed(MouseEvent eStart){
			startPoint = new Point(eStart.getX(),eStart.getY());
			//System.out.println("Point: "+ e1.getX() +e1.getY());
		}
		public void mouseReleased(MouseEvent eEnd){
			endPoint = new Point(eEnd.getX(),eEnd.getY());
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