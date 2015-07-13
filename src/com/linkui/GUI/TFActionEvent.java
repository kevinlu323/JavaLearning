package com.linkui.GUI;

import java.awt.*;
import java.awt.event.*;

public class TFActionEvent {
	public static void main(String[] args){
		new TFFrame();
	}
}

class TFFrame extends Frame{
	TFFrame(){
		TextField tf = new TextField();
		add(tf);
		tf.addActionListener(new TFActionListener());
		pack();
		setVisible(true);
	}
}

class TFActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		//System.out.println((TextField)e.getSource());
		tf.setText("");
	}
}