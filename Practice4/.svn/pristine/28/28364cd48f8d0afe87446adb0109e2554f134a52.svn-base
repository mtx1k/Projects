package ua.nure.shekhovtsov.Practice4.part3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	public void print(String line, String str) throws IOException {
		if("char".equals(str)) {			
			System.out.println(returnChar(line));
		}
		else if("String".equals(str)) {
			System.out.println(returnString(line));
		}
		else if("int".equals(str)) {
			System.out.println(returnInt(line));
		}
		else if("double".equals(str)) {
			System.out.println(returnDouble(line));
		}
	}
	
	public String returnChar(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuffer buffer = new StringBuffer();
		while(st.hasMoreTokens()) {
			//System.out.println(st.nextToken());
			String temp = st.nextToken();
			if(temp.toCharArray().length == 1) {
				buffer.append(temp + " ");
			}
		}
		return buffer.toString();
	}
	
	public String returnString(String str) {
		StringBuffer buffer = new StringBuffer();
		Pattern p = Pattern.compile("[Р-пр-џa-zA-Z]{2,}");
		Matcher m = p.matcher(str);
		while(m.find()) {
			buffer.append(m.group() + " ");
		}
		return buffer.toString();
	}
	
	public String returnInt(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuffer buffer = new StringBuffer();
		while(st.hasMoreTokens()) {
			try {
				int i = Integer.parseInt(st.nextToken());
				buffer.append(i + " ");
			}
			catch(Exception e) {
				continue;
			}
		}
		return buffer.toString();
	}
	
	public String returnDouble(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuffer buffer = new StringBuffer();
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			if(temp.contains(".")) {
				buffer.append(temp + " ");
			}
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		File file = new File("part3.txt");
		BufferedReader brText = new BufferedReader(new FileReader(file));
		String line = brText.readLine();
		Part3 part3 = new Part3();
		String str = "";
		while(true) {
			str = br.readLine();
			if("exit".equals(str)) {
				break;
			} else {
				part3.print(line, str);
			}
		}
		br.close();
		brText.close();
	}
}