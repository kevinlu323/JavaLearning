package com.linkui.basic;

//���� 
class Father2{ 
  //������һ�����ӷ��� 
  public void hitChild(){ 
  } 
} 
//����1 
class Son1 extends Father2{ 
  //��д������ӷ��� 
  public void hitChild(){ 
    System.out.println("Ϊʲô���ң�������ʲô�ˣ�"); 
  } 
} 
//����2 
class Son2 extends Father2{ 
  //��д������ӷ��� 
  public void hitChild(){ 
    System.out.println("��֪�����ˣ�����ˣ�"); 
  } 
} 
//����3 
class Son3 extends Father2{ 
  //��д������ӷ��� 
  public void hitChild(){ 
    System.out.println("���ܣ�����ţ�"); 
  } 
} 
//������ 
public class TestPolymorphism2{ 
  public static void main(String args[]){ 
    Father2 father; 
    father = new Son1(); 
    father.hitChild(); 
    father = new Son2(); 
    father.hitChild(); 
    father = new Son3(); 
    father.hitChild(); 
  } 
} 
