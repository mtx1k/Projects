package ua.nure.shekhovtsov.Practice4.part4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Parser implements Iterable<String> {

	private String[] texts = null;
	
	private int length = 2;

	private final String FILENAME;

	private final String ENCODING;
	
	private final String SEPARATOR = System.lineSeparator();

	public Parser(String fileName, String encoding) throws IOException {
		FILENAME = fileName;
		ENCODING = encoding;
		texts = new String[length];
		getSentenses(readFromFile());
	}

	private String readFromFile() throws IOException {
		StringBuffer buf = new StringBuffer();
		String temp = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(FILENAME),ENCODING));
			while((temp = br.readLine())!=null) {

				buf.append(temp.replace(SEPARATOR, ""));
			}
		} catch(UnsupportedEncodingException e) {
			throw new Error(e);
		} /*catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}*/ finally { 
	        if (br != null) br.close();
	    }
		return buf.toString();
	}
	
	private void getSentenses(String text) {
		Pattern p = Pattern.compile("[A-ZÀ-ß].*?\\.");
		Matcher m = p.matcher(text);
		int i = 0;
		while(m.find()) {
			if(length == i) {
				String[] tmp = new String[length + 10];
				System.arraycopy(texts, 0, tmp, 0, length);
				texts = tmp;
			}
			texts[i] = m.group();
			i++;
		}
		length = i;
	}

	@Override
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			private int count = 0;
			public boolean hasNext(){
				return count < length;
			}
			public String next(){
				return texts[count++];
			}

			public void remove(){
				throw new UnsupportedOperationException();
			}
		};
	}

}