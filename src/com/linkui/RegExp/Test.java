package com.linkui.RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args){
		/*p("abc".matches("..."));
		p("a8729b".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}"); //more efficiency
		Matcher m = p.matcher("fgh");
		p(m.matches());
		p("fgh".matches("[a-z]{3}"));*/
		
		// Learn   . * + ?
		/*p("a".matches("."));
		p("aa".matches("aa"));
		p("aaaa".matches("a*"));
		p("aaaa".matches("a+"));
		p("".matches("a*"));
		p("aaaa".matches("a?")); //false
		p("".matches("a?"));
		p("a".matches("a?"));
		p("214523145234532".matches("\\d{3,100}"));
		p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		p("192".matches("[0-2][0-9][0-9]"));*/
		
		//learn \s \w \d \
		/*p(" \n\r\t".matches("\\s{4}"));
		p(" ".matches("\\S"));
		p("a_8".matches("\\w{3}"));
		p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		p("\\".matches("\\\\"));*/
		
		//POSIX style
		//p("a".matches("\\p{Lower}"));
		
		//boundary
		/*p("hello sir".matches("^h.*")); // ^ is beginning
		p("hello sir".matches(".*ir$")); // $ is end
		p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));  // \b a word boundary
		p("hellosir".matches("^h[a-z]{1,3}o\\b.*"));*/
		
		//white line
		//p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));   //[^\\n]] means beginning with not a \\n
		
		//exercise
		/*p("aaa 8888c".matches(".*\\d{4}."));
		p("aaa 8888c".matches(".*\\b\\d{4}."));
		p("aaa8888c".matches(".*\\d{4}."));
		p("aaa888c".matches(".*\\b\\d{4}."));*/
		
		//match Email
		//p("test123@gmail.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));
		
		//matches find lookingat
		/*Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34345-234-00";
		Matcher m = p.matcher(s);
		p(m.matches());  //after matches(), "123-" is cut, so need reset()
		m.reset();
		p(m.find());
		p(m.start() + "-" +m.end());
		p(m.find());
		p(m.start() + "-" +m.end());
		p(m.find());
		p(m.start() + "-" +m.end());
		p(m.find());
		
		p(m.lookingAt()); // lookingAt() will always look from beginning.
		p(m.lookingAt());
		p(m.lookingAt());
		p(m.lookingAt());*/
		
		//replace
		/*Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVa JaVa I loveJAVA you hateJava asdferyhrt");
		//p(m.replaceAll("JAVA"));
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m.find()){
			i++;
			if(i%2==0){
				m.appendReplacement(buf, "java");
			}
			else{
				m.appendReplacement(buf, "JAVA");
			}
		}
		m.appendTail(buf);
		p(buf);*/
		
		//group
		Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})");
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()){
			p(m.group(1));
		}
		
	}
	
	public static void p(Object o){
		System.out.println(o);
	}
}
