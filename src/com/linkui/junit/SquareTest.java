package com.linkui.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)
public class SquareTest {
	private Calculator cal;
	private int rest, param;
	
	@Before
	public void setUp(){
		cal = new Calculator();
	}
	
	@After
	public void tearDown(){
		cal = null;
	}
	
	@Parameters
	public static Collection data(){
		return Arrays.asList(new Object[][] {{2,4},{-1,1},{0,0},{-3,9}});
	}
	
	//constructor
	public SquareTest(int param, int rest){
		this.param = param;
		this.rest = rest;
	}
	@Test
	public void testSquare() {
		int tmp = cal.square(param);
		assertEquals(tmp, rest);
	}

}
