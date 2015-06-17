package com.linkui;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
 
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
 
public class MainFrame extends JFrame implements ItemListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JComboBox college;
    private JComboBox major;
    private Map<Integer, Vector<String>> map = new HashMap<Integer, Vector<String>>();
     
    public MainFrame() {
        Vector<String> collegeItems = new Vector<String>();
        collegeItems.add("物信学院");
        collegeItems.add("数统学院");
        collegeItems.add("文史学院");
        college = new JComboBox(collegeItems);
        college.addItemListener(this);
         
        //物信学院的专业
        Vector<String> vector0 = new Vector<String>();
        vector0.add("物理");
        vector0.add("计算机");
        vector0.add("电信");
        map.put(0, vector0);
         
        //数统学院的专业
        Vector<String> vector1 = new Vector<String>();
        vector1.add("应用数学");
        vector1.add("统计学");
        vector1.add("理论数学");
        map.put(1, vector1);
         
        //文史学院的专业
        Vector<String> vector2 = new Vector<String>();
        vector2.add("汉语言文学");
        vector2.add("历史");
        vector2.add("戏剧文学");
        map.put(2, vector2);
         
         
        major = new JComboBox(new DefaultComboBoxModel(map.get(0)));
        major.addItemListener(this);
        JPanel panel = new JPanel();
        panel.add(college);
        panel.add(major);
         
        this.add(panel, BorderLayout.NORTH);       
        this.setTitle("JComboBox示例");
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    public void itemStateChanged(ItemEvent e) {
        //在JComboBox的监听事件时总是执行两次,原因如下:
        //ItemListener类中的方法itemStateChanged()事件的itemState有关，itemState在这里的状态有两个，Selected 和 deSelected（即选中和未被选中）
        //所以，当改变下拉列表中被选中的项的时候，其实是触发了两次事件：
        //第一次是上次被选中的项的 State 由 Selected 变为 deSelected ，即取消选择
        //第二次是本次被选中的项的 State 由 deSelected 变为 Selected ，即新选中，所以，必然的 ItemStateChanged 事件中的代码要被执行两次了。
        //加上最外面的if语句，就可以解决这个问题。
        if(e.getStateChange() == ItemEvent.SELECTED) {
            if(e.getSource() == college) {
                int index = college.getSelectedIndex();
                major.setModel(new DefaultComboBoxModel(map.get(index)));
            } else if(e.getSource() == major) {
                JOptionPane.showMessageDialog(this, "你选择的是：" + college.getSelectedItem() + "的" + major.getSelectedItem() + "专业！");
            }
        }       
    }
     
    public static void main(String[] args) {
        new MainFrame();
    }
}