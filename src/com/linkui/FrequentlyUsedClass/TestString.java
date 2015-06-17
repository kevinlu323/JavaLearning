package com.linkui.FrequentlyUsedClass;

public class TestString {
	public static void main(String[] args) {
		String s ="saflksanglkrewqfLNBSFfswefSFlsdfn1249328r9fwdsafdSFN";
		String s1 = "sunjavaoraclejavahpjavaokjavahahajava";
		int lCount = 0, uCount = 0, oCount = 0;
		
		/*for(int i =0;i<s.length();i++){
			char c = s.charAt(i);
			if (c>='a' && c<='z'){
				lCount++;
			} else if (c>='A' && c<='Z'){
				uCount++;
			} else {
				oCount++;
			}		
		}*/
		
		String sL = "abcdefghijklmnopqrstuvwxyz";
		String sU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		for(int i =0;i<s.length();i++){
			char c = s.charAt(i);
			if (sL.indexOf(c)!=-1){
				lCount++;
			} else if (sU.indexOf(c)!=-1){
				uCount++;
			} else {
				oCount++;
			}		
		}
		System.out.println(lCount + " " + uCount + " " + oCount);
		String sToFind = "java";
		int count=0;
		int index =s1.indexOf(sToFind);
		if(index!=-1){
			count++;
		} else {
			System.out.println("Not found!");
		}
		s1=s1.substring(index+sToFind.length());
		while (s1.indexOf(sToFind)!=-1){
			index =s1.indexOf(sToFind);
			s1=s1.substring(index+sToFind.length());
			count++;
		}
		System.out.println("count of: "+sToFind + " is: " + count);
		
	}
}
