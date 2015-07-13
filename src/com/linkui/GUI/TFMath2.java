package com.linkui.GUI;

import java.awt.*;
import java.awt.event.*;

public class TFMath2 {
	public static void main(String[] args){
		new TFFrameMath2().launchFrame();
	}
}

class TFFrameMath2 extends Frame{
	TextField num1;
	TextField num2;
	TextField num3;
	public void launchFrame(){
		num1 = new TextField(10);
		num2 = new TextField(10);
		num3 = new TextField(15);
		Label lblPlus = new Label("+");
		Button btnEqual = new Button("=");
		btnEqual.addActionListener(new MyMonitor2());
		setLayout(new FlowLayout());
		add(num1);
		add(lblPlus);
		add(num2);
		add(btnEqual);
		add(num3);
		setLocation(800,500);
		pack();
		setVisible(true);		
	}
	
	//Inner class
	private class MyMonitor2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int n1 = Integer.parseInt(num1.getText());
			int n2 = Integer.parseInt(num2.getText());
			num3.setText(""+(n1+n2));
		}
	}
}

/*class MyMonitor implements ActionListener{
	TextField num1;
	TextField num2;
	TextField num3;
	
	public MyMonitor(TextField num1, TextField num2, TextField num3){
		this.num1=num1;
		this.num2=num2;
		this.num3=num3;
	}
	TFFrameMath tf = null;
	public MyMonitor(TFFrameMath tf){
		this.tf=tf;
	}
	public void actionPerformed(ActionEvent e){
		int n1 = Integer.parseInt(tf.num1.getText());
		int n2 = Integer.parseInt(tf.num2.getText());
		tf.num3.setText(""+(n1+n2));
	}
}*/