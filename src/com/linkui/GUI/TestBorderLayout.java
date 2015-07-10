package com.linkui.GUI;

import java.awt.*;

public class TestBorderLayout {

	public static void main(String[] args){
		Frame f = new Frame("Border Layout");
		Button bn = new Button ("NORTH");
		Button bs = new Button("SOUTH");
		Button bw = new Button("WEST");
		Button be = new Button ("EAST");
		Button bc = new Button("CENTER");
		
		//not recommand
		//f.add(bn,"North");
		
		
		f.add(bn,BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.EAST);
		f.add(bc, BorderLayout.CENTER);
		
		f.setSize(400, 200);
		f.setVisible(true);
	}
}
