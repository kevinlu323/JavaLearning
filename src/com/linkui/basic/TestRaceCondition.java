package com.linkui.basic;

import java.util.concurrent.atomic.AtomicInteger;

class MyThread implements Runnable {
    /**
     * 计算类型，1表示减法，其他的表示加法
     */
    private int type;

    public MyThread(int type) {
        this.type = type;
    }

    public void run() {
        if (type == 1)
            for (int i = 0; i < 10000; i++){
            	TestRaceCondition.num--;
            	TestRaceCondition.num1.getAndDecrement();
            }
        else
            for (int i = 0; i < 10000; i++){
            	TestRaceCondition.num++;
        		TestRaceCondition.num1.getAndIncrement();
            }
    }
}

public class TestRaceCondition {

    public static volatile int num = 1000000; //still incorrect, because "++/--" is not atomic
    public static volatile AtomicInteger num1 = new AtomicInteger(1000000);

    public static void main(String[] args) {

        Thread a = new Thread(new MyThread(1));
        Thread b = new Thread(new MyThread(2));

        a.start();
        b.start();

        /*
         * 主线程等待子线程完成，然后再打印数值
         */
        try {
            a.join();
            b.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(num);
        System.out.println(num1);
    }

}