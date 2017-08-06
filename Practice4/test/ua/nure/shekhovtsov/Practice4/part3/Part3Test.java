package ua.nure.shekhovtsov.Practice4.part3;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ua.nure.shekhovtsov.Practice4.part3.Part3;

public class Part3Test {

	private Part3 part3;
	
	@Before
	public void setUp() {
		part3 = new Part3();
		System.out.println("\t-->\t" + part3);
	}
		
	@Test
	public void testMain() throws IOException {
		System.setIn(new ByteArrayInputStream("char\nString\nint\ndouble\nexit".getBytes("cp1251")));
		Part3.main(new String[] {});
		System.setIn(System.in);
	}
	
	@Test
	public void testDefaultConstructor() {
		new Part3();
	}
}
