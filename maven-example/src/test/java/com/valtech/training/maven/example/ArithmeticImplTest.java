package com.valtech.training.maven.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticImplTest {
	@Test
    public void addtest() {
        Arithmetic a = new ArithmeticImpl();
        assertEquals(5, a.add(2, 3));
        assertEquals(5, a.add(3, 2));
        assertEquals(5, a.add(1, 4));
        assertEquals(5, a.add(4, 1));
        assertEquals(23, a.add(12, 11));
        assertEquals(23, a.add(11, 12));
    


		
	}
	@Test
	public void testsub() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(7,a.sub(10,3));
		assertEquals(4,a.sub(9,5));
		
	}

@Test
	public void testmul() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(6,a.mul(2,3));
		assertEquals(7,a.mul(1,7));
		
	}
	@Test
	public void testdiv() {
		Arithmetic a = new ArithmeticImpl();
		assertEquals(2,a.div(10,5));
		assertEquals(1,a.div(7,7));
		try
		{
			a.div(3, 0);
			fail("Arithmetic Exception was expected with '/ by zero'");
		}catch(ArithmeticException ae) {
		
		}
		
	}
}

