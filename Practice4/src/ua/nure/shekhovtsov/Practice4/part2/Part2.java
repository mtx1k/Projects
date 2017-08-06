package ua.nure.shekhovtsov.Practice4.part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Part2 {

	private static final String FILE_NAME = "part2.txt";

	private static final String FILE_NAME2 = "part2_sorted.txt";

	private static final int N = 10;

	private static final int MAX = 50;

	public void createAndFillFile() throws IOException {
		File file = new File(FILE_NAME);
		FileWriter fr = new FileWriter(file);
		for (int i = 0; i < N; i++) {
			fr.write((int)(Math.random()*MAX) + " ");
		}
		fr.close();
	}
	
	public void sortToFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		String temp;
		int[] arr = new int[N];
		while((temp = br.readLine())!=null) {
			String[] a = temp.split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(a[i]);
			}
		}
		for (int i = 0; i < arr.length-1; i++){
	        for (int j = i+1; j < arr.length; j++){
	            if (arr[i] > arr[j]) {
	                int t = arr[i];
	                arr[i] = arr[j];
	                arr[j] = t;
	            }
	        }
	    }
		br.close();
		File file = new File(FILE_NAME2);
		FileWriter fr = new FileWriter(file);
		for (int i = 0; i < N; i++) {
			fr.write(arr[i] + " ");
		}
		fr.close();
	}
	
	public void print() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		String temp = "";
		while((temp = br.readLine())!=null) {
			System.out.println(temp);
		}
		BufferedReader br2 = new BufferedReader(new FileReader(FILE_NAME2));
		while((temp = br2.readLine())!=null) {
			System.out.println(temp);
		}
		br.close();
		br2.close();
	}
	
	public static void main(String[] args) throws IOException {
		Part2 part2 = new Part2();
		part2.createAndFillFile();
		part2.sortToFile();
		part2.print();
	}

}