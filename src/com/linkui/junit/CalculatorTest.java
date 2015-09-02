package com.linkui.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator cal;

	@Before
	public void setUp() {
		cal = new Calculator();
	}

	@After
	public void tearDown() {
		cal = null;
	}

	@Test
	public void testAdd() {
		int result = cal.add(2, 3);
		assertEquals(5, result);
	}

	@Test
	public void testMinus() {
		int result = cal.minus(2, 3);
		assertEquals(-1, result);
	}

	@Test
	public void testMultiply() {
		int result = cal.multiply(3, 0);
		assertEquals(0, result);
	}

	@Test(timeout = 1000)
	public void testSquareRoot() {
		cal.squareRoot(4);
	}

	@Test
	public void testDivide() {
		int result = 0;
		try {
			result = cal.divide(4, 2);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception occurs");
		}
		assertEquals(2, result);
	}

	@Test
	public void testDividedByZero() {
		Throwable th = null;
		try {
			cal.divide(5, 0);
			fail("Divided by 0 has no exception");
		} catch (Exception e) {
			th = e;
		}
		assertNotNull(th);
		assertEquals(ArithmeticException.class, th.getClass());
		assertEquals("Divisor is 0", th.getMessage());
	}

	@Test(expected = ArithmeticException.class)
	public void testDividedByZero2() throws Exception {
		cal.divide(4, 0);
	}

	@Test
	public void testFormula() {
		Class c = cal.getClass();
		Class[] params = { char.class, int[].class };
		Method method = null;
		try {
			method = c.getDeclaredMethod("formulaStr", params);
		} catch (SecurityException e) {
			System.err.println("反射调用formulaStr方法失败");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.err.println("不存在formulaStr方法");
			e.printStackTrace();
		}
		method.setAccessible(true);
		int[] nums = { 3, 5, 8 };
		try {
			assertEquals("3+5+8=", method.invoke(cal, '+' , nums));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBonus(){
		Class c = cal.getClass();
		Method method = null;
		try {
			method = c.getDeclaredMethod("getBonus", String.class);
		} catch (NoSuchMethodException e) {
			System.out.println("method not found");
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		method.setAccessible(true);
		String testIn = "I wanna bonus!";
		try {
			assertEquals("you get the bonus!", method.invoke(cal, testIn));
			assertEquals(null, method.invoke(cal, "I wanna"));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
