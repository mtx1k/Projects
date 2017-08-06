package ua.nure.shekhovtsov.Practice4.part5;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ua.nure.shekhovtsov.Practice4.part5.Part5;

public class Part5Test {
	private Part5 part5;
	
	@Before
	public void setUp() {
		part5 = new Part5();
		System.out.println("\t-->\t" + part5);
		System.setIn(System.in);
	}
		
	@Test
	public void testMain() throws IOException {
		System.setIn(new ByteArrayInputStream("table ru\ntable en\napple ru\nexit".getBytes("Cp1251")));
		Part5.main(new String[] {});
		System.setIn(System.in);
	}
	
	@Test
	public void testDefaultConstructor() {
		new Part5();
	}
}
