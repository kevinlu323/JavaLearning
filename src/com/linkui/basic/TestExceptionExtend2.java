package com.linkui.basic;

@SuppressWarnings("serial")
class Annoyance extends Exception{}
@SuppressWarnings("serial")
class Sneeze extends Annoyance{}

public class TestExceptionExtend2 {
	public static void main(String[] args){
		try{
			try{
				throw new Sneeze();
			}
			catch (Annoyance a){
				System.out.println("Caught Annoyance");
				throw a;
			}
		}
		catch (Sneeze s){
			System.out.println("Caught Sneeze");
			return;
		}
		finally{
			System.out.println("Hello World");
		}
	}
}
