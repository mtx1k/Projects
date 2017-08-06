package ua.nure.shekhovtsov.Practice4.part4;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import ua.nure.shekhovtsov.Practice4.part4.Part4;

public class Part4Test {

	private Part4 part4;
	
	private Parser parser;
	
	private static final String FILE_NAME = "part4.txt";

	private static final String ENCODING = "Cp1251";
	
	@Before
	public void setUp() {
		part4 = new Part4();
		System.out.println("\t-->\t" + part4);
	}
		
	@Test
	public void testMain() throws IOException {
		Part4.main(new String[] {});
	}
	
	@Test
	public void testDefaultConstructor() {
		new Part4();
	}
	
	@Test(expected = Error.class)
	public void testreadFromFile2() throws IOException {
		parser = new Parser(FILE_NAME, "sdhfgsadilsuadhfiusadhfiusadhfiu");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testIterator() throws IOException {
		parser = new Parser(FILE_NAME, ENCODING);
		Iterator<String> iterator = parser.iterator();
		iterator.remove();
	}	
	@Test(expected = IOException.class)
	public void testreadFromFile() throws IOException {
		parser = new Parser("", ENCODING);
	}
}
