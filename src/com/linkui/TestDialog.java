package com.linkui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestDialog extends JFrame implements ActionListener,Runnable {
    
    JLabel jLabel1 = new JLabel();

    JLabel jLabel2 = new JLabel();

    JTextField jtUserID = new JTextField();

    JLabel jLabel3 = new JLabel();

    JPasswordField jpUsePwd = new JPasswordField();

    JButton jbEnter = new JButton();

    JButton jbExit = new JButton();
    
    //设置登陆的用户名和密码
    
    String userID="123";
    String userPwd="123";
    
    public TestDialog() {
        super("用户登陆界面");
        try {
            // 设置窗体的大小、位置、可见性

            jbInit();
            this.setVisible(true);
            this.setSize(410, 300);
            this.addWindowListener(new WindowAdapter() { // 清空内存
                        public void windowClosing(WindowEvent e) {
                            System.exit(0);
                        }
                    });
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        // 初始化各控件，设置控件位置，将控件添加到面板上
        getContentPane().setLayout(null);
        jtUserID.setText("");
        jtUserID.setBounds(new Rectangle(182, 50, 141, 22));
        jLabel2.setText("用户名：");
        jLabel2.setBounds(new Rectangle(83, 50, 78, 24));
        jLabel3.setText("密    码：");
        jLabel3.setBounds(new Rectangle(81, 91, 78, 24));
        jpUsePwd.setBounds(new Rectangle(182, 92, 140, 27));
        jbEnter.setBounds(new Rectangle(122, 197, 90, 25));
        jbEnter.setText("登陆");
        jbExit.setBounds(new Rectangle(217, 197, 90, 25));
        jbExit.setText("退出");
        this.getContentPane().add(jLabel2);
        this.getContentPane().add(jLabel3);
        this.getContentPane().add(jLabel1);
        this.getContentPane().add(jtUserID);
        this.getContentPane().add(jpUsePwd);
        this.getContentPane().add(jbEnter);
        this.getContentPane().add(jbExit);

        jbEnter.addActionListener(this);
        jbExit.addActionListener(this);

    }


//多线程控制登陆信息框
    public void run(){
        try{
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, "正在登陆中....");
        Thread.sleep(3000);
        this.dispose();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }

//当点击按钮的时候触发下面的方法
    public void actionPerformed(ActionEvent e) {
        try{
        String command=e.getActionCommand();
        if (command.equals("退出")) {
            System.exit(0);
        } else {

            // 管理员登陆功能实现

            if (jtUserID.getText().equals("")
                    || new String(jpUsePwd.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(null, "请输入完整数据");
            } else {
                        if (jtUserID.getText().equals(userID)
                                && new String(jpUsePwd.getPassword())
                                        .equals(userPwd)) {
                            Thread t=new Thread(this);
                            t.start();
                            
                        

                        }
                     else {
                        JOptionPane.showMessageDialog(null, "帐号或者密码错误");
                        jtUserID.setText("");
                        jpUsePwd.setText("");
                        }
                        }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        }
    public static void main(String[] args) {
         new TestDialog();
    }
}