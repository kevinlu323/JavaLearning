package com.linkui.problems;

public class ComputeArea {
	public static void main (String[] args){
		int a = -3, b = 0, c = 3, d = 4;
		int e = 0, f = -1, g = 9, h = 2;
		int area = computeArea(a,b,c,d,e,f,g,h);
		System.out.println(area);
	}
	
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if(A == B && B == C && C== D){
			return Math.abs(G-E) * Math.abs(H-F);
		}
		else if (E == F && F == G && G== H){
			return Math.abs(C-A) * Math.abs(D-B);
		}
		else if(A>=G || D<=F || C<=E || B>=H){ // not overlapped
			return (Math.abs(C-A) * Math.abs(D-B)) + (Math.abs(G-E) * Math.abs(H-F));
		}
		else{
			return (Math.abs(C-A) * Math.abs(D-B)) + (Math.abs(G-E) * Math.abs(H-F)) - 
					(Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
		}
	}
}
