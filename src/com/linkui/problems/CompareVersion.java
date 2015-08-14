package com.linkui.problems;

public class CompareVersion {
	public static void main(String[] args){
		String v1 = "1.1.0.1";
		String v2 = "1.1";
		System.out.println(compareVersion(v1,v2));
	}
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int len1 = v1.length;
		int len2 = v2.length;
		System.out.println(len1 +":" +len2);
		int minLen = Math.min(len1, len2);
		for (int i = 0; i<minLen; i++){
			if(Integer.valueOf(v1[i])> Integer.valueOf(v2[i])) return 1;
			else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i])) return -1;
		}
		if(len1 > len2 && Integer.valueOf(v1[minLen])>0) return 1;
		else if (len1 <len2 && Integer.valueOf(v2[minLen])>0) return -1;
		return 0;
	}
}
