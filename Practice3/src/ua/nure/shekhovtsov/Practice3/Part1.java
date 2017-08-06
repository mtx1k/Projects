package ua.nure.shekhovtsov.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	public static String convert1(String input) {
		String str = input;
		str = str.replaceFirst("^.*?\n", "");
		str = str.replaceAll("(?m)^(.*);.*;(.*)$", "$1 ==> $2");
		return str;
	}

	public static String convert2(String input) {
		String str = input;
		str = str.replaceFirst("^.*?\n", "");
		str = str.replaceAll("(?m)^.*;(.*);(.*)$", "$1 (email: $2)");
		return str;
	}

	public static String convert3(String input) {
		String str = input;
		StringBuffer buffer = new StringBuffer();
		str = str.replaceFirst("^.*?\n", "");
		Pattern p = Pattern.compile("(?m)^(.*);.*;.*@(.*)$");
		Matcher m = p.matcher(str);
		while (m.find()) {
			if (buffer.toString().contains(m.group(2))) {
				continue;
			}
			buffer.append(m.group(2)).append(" ==> ").append(m.group(1));
			Matcher m2 = p.matcher(str);
			while (m2.find()) {
				if (m2.group(1).equals(m.group(1))) {
					continue;
				} else if (m2.group(2).equals(m.group(2))) {
					buffer.append(", ").append(m2.group(1));
				}
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}

	public static String convert4(String input) {
		StringBuffer buffer = new StringBuffer();
		Pattern p = Pattern.compile("(?m)^(.*;.*;.*)$");
		Matcher m = p.matcher(input);
		boolean b = true;
		while (m.find()) {
			if (b) {
				buffer.append(m.group(1)).append(";Password\n");
				b = false;
				continue;
			}
			buffer.append(m.group(1)).append(";")
					.append((int) (Math.random() * 9000 + 1000)).append("\n");
		}
		return buffer.toString();
	}
}