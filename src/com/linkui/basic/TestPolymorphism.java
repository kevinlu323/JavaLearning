package com.linkui.basic;

public class TestPolymorphism {
	public static void main(String[] args) { 
        Father child = new Child(); 
        child.func1();//��ӡ���������ʲô��  
        //child.func1(68); not able to call public void func1(int i) in child class
    } 
}

class Father{ 
	int num = 1;
    public void func1(){ 
        func2(); 
    } 
    //���Ǹ����е�func2()��������Ϊ�������������д�˸÷��� 
    //�����ڸ������͵������е���ʱ�����������������Ч 
    //ȡ����֮���ǽ�������������д��func2()���� 
    public void func2(){ 
        System.out.println("AAA"); 
    } 
} 
  
class Child extends Father{ 
	int num = 2;
    //func1(int i)�Ƕ�func1()������һ�����أ���Ҫ������д��
    //�����ڸ�����û�ж���������������������ܱ��������͵����õ��� 
    //�����������main������child.func1(68)�ǲ��Ե� 
    public void func1(int i){ 
        System.out.println("BBB"); 
    } 
    //func2()��д�˸���Father�е�func2()���� 
    //����������͵������е�����func2()��������ô��Ȼ����������д��������� 
    public void func2(){ 
        System.out.println("CCC"); 
    } 
} 

class AbFather{
	
}
