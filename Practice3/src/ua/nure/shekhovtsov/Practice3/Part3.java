package ua.nure.shekhovtsov.Practice3;

import java.util.StringTokenizer;

public class Part3 {
	public static String first2ApperCase(String text) {
		StringBuffer buffer = new StringBuffer();
		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {
			char[] arr = st.nextToken().toCharArray();
			arr[0] = Character.toUpperCase(arr[0]);
			buffer.append(arr).append(" ");
		}
		return buffer.toString();
	}
}