package ua.nure.shekhovtsov.Practice4.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class Part1 {

	private static final String FILE_NAME = "part1.txt";

	private static final String EOL = System.lineSeparator();
	
	private static final String ENCODING = "Cp1251";

	public String fileToUpperCase(File file, String encoding) throws FileNotFoundException {
		Scanner s = new Scanner(file, encoding);
		String content = null;
		StringBuilder sb = new StringBuilder();
		while (s.hasNextLine()) {
			sb.append(s.nextLine()).append(EOL);
		}
		content = sb.substring(0, sb.length() - EOL.length());
		s.close();
		//System.out.println(content);
		Pattern p = Pattern.compile("[à-ÿÀ-ß]{4,}");
		Matcher m = p.matcher(content);
		while(m.find()) {
			char[] arr = m.group().toCharArray();
			for (int i = 3; i < arr.length; i++) {
				arr[i] = Character.toUpperCase(arr[i]);
			}
			content = content.replace(m.group(), String.valueOf(arr));
		}
		return content;
	}
	
	public void printText(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(FILE_NAME);
		Part1 part1 = new Part1();
		String str = part1.fileToUpperCase(file, ENCODING);
		part1.printText(str);
	}
}