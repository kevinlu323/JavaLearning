package com.linkui.GUI;

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent2 {
	public static void main(String[] args){
		Frame f = new Frame("Test");
		Button b1 = new Button("Start");
		Button b2 = new Button("Stop");
		Monitor2 bh = new Monitor2();
		b1.addActionListener(bh);
		b2.addActionListener(bh);
		b2.setActionCommand("Game Over!");
		f.add(b1, "North");
		f.add(b2,"Center");
		f.pack();
		f.setVisible(true);
	}
}

class Monitor2 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		System.out.println("a button has been pressed,"+
				" the relative info is:\n"+e.getActionCommand());
	}
}