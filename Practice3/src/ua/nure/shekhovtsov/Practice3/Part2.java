package ua.nure.shekhovtsov.Practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Part2 {
	private static int min = Integer.MAX_VALUE, max = 0;;
	private static List<String> minList = new ArrayList<>();
	private static List<String> maxList = new ArrayList<>();

	public static void string2words(String text) {
		StringTokenizer st = new StringTokenizer(text, " \t\n\r,:-'");
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			if (temp.length() == min) {
				if (!minList.contains(temp)) {
					minList.add(temp);
				}
			} else if (temp.length() < min) {
				min = temp.length();
				minList = new ArrayList<>();
				minList.add(temp);
			} else if (temp.length() == max) {
				if (!maxList.contains(temp)) {
					maxList.add(temp);
				}
			} else if (temp.length() > max) {
				max = temp.length();
				maxList = new ArrayList<>();
				maxList.add(temp);
			}
		}
	}

	public static void print() {
		System.out.print("Min: ");
		for (String s : minList) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.print("Max: ");
		for (String s : maxList) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}