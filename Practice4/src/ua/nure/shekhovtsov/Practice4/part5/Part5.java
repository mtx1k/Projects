package ua.nure.shekhovtsov.Practice4.part5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class Part5 {

	private static final String BASE_NAME = "resources";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String temp = br.readLine();
			if("exit".equals(temp)) {
				break;
			}
			StringTokenizer token = new StringTokenizer(temp);
			String key = token.nextToken();
			String local = token.nextToken();
			Locale locale = new Locale(local);
			ResourceBundle rb = ResourceBundle.getBundle(BASE_NAME, locale);
			System.out.println(rb.getString(key));
		}
	}
}