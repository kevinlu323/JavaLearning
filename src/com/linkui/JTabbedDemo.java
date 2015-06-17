package com.linkui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class JTabbedDemo extends JFrame {

	 private JTabbedPane tab;
	 public JTabbedDemo(){
	  tabType();
	  
	  tab = new JTabbedPane(JTabbedPane.LEFT);
	  tab.addTab("线形", new BorderPanel(BorderFactory.createLineBorder(Color.BLUE, 5)));
	  
	  tab.addTab("圆角", new BorderPanel(new LineBorder(Color.GRAY,5,true)));
	  
	  tab.addTab("三维效应", new BorderPanel(BorderFactory.createEtchedBorder(EtchedBorder.RAISED)));
	  
	  tab.addTab("斜教", new BorderPanel(BorderFactory.createRaisedBevelBorder()));
	  
	  tab.addTab("软斜角", new BorderPanel(new SoftBevelBorder(SoftBevelBorder.LOWERED)));
	  
	  tab.addTab("组合", new BorderPanel(BorderFactory.createCompoundBorder(
	    BorderFactory.createEmptyBorder(15, 15, 15, 15), new LineBorder(Color.gray,2,true))));
	  
	  tab.addTab("标题", new BorderPanel(BorderFactory.createTitledBorder(
	    BorderFactory.createLineBorder(Color.GRAY), "Nagisa", TitledBorder.CENTER, 
	    TitledBorder.TOP, new Font("微软雅黑", Font.BOLD, 20), Color.BLUE)));
	  
	  tab.addTab("图形", new BorderPanel(BorderFactory.createMatteBorder(50, 50, 50, 50, 
	    new ImageIcon(System.getProperty("user.dir") + "/img/han.gif"))));
	  
	  add(tab);
	  pack();
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setVisible(true);
	 }
	 
	 private void tabType(){
	  ItemListener l = new ItemListener(){

	   @Override
	   public void itemStateChanged(ItemEvent e) {
	    String text = ((JRadioButton)e.getItem()).getText();
	    if(text.equals("Left")){
	     tab.setTabPlacement(JTabbedPane.LEFT);
	    }else if(text.equals("Right")){
	     tab.setTabPlacement(JTabbedPane.RIGHT);
	    }else if(text.equals("Top")){
	     tab.setTabPlacement(JTabbedPane.TOP);
	    }else{
	     tab.setTabPlacement(JTabbedPane.BOTTOM);
	    }
	   }
	   
	  };
	  
	  JPanel p = new JPanel();
	  ButtonGroup group = new ButtonGroup();
	  JRadioButton radio = new JRadioButton("Left",true);
	  radio.addItemListener(l);
	  group.add(radio);
	  p.add(radio);
	  
	  radio = new JRadioButton("Right");
	  radio.addItemListener(l);
	  group.add(radio);
	  p.add(radio);
	  
	  radio = new JRadioButton("Top");
	  radio.addItemListener(l);
	  group.add(radio);
	  p.add(radio);
	  
	  radio = new JRadioButton("Bottom");
	  radio.addItemListener(l);
	  group.add(radio);
	  p.add(radio);
	  
	  add(p,BorderLayout.NORTH);
	  
	 }
	 
	 public static void main(String[] args){
	  new JTabbedDemo();
	 }
	}
	@SuppressWarnings("serial")
	class BorderPanel extends JPanel {
	    private Insets inset;
	    private int w;
	    private int h;
	 public BorderPanel(Border b){
	  inset = getInsets();
	  w = 600 + inset.left + inset.right;
	  h = 800 + inset.top + inset.bottom;
	  setPreferredSize(new Dimension(w,h));
	  setBorder(b);
	 }

	}