package ua.nure.shekhovtsov.Practice1;

public class Part5 {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("not arguments!");
			System.exit(0);
		}		
		System.out.println(args[0]);
		System.out.println(Integer.parseInt(args[1]));
		System.out.println(args[2]);
	}
	
	public static int chars2digits(String number) {
		char[] arr = number.toCharArray();
		int n = 0;
		for(int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
			n += ((int)arr[i] - 64)*Math.pow(26, j);
		}
		return n;		
	}
	
	public static String digits2chars(int number) {
		String str = "";
		int number1 = number;
		do {
			int temp = number1%26;
			number1 /= 26;
			if(temp == 0) {
				temp = 26;
				number1--;
			}
			str = (char)(temp + 64) + str;
		} while(number1 != 0);
		return str;		
	}
	
	public static String rightColumn(String number) {
		return digits2chars(chars2digits(number)+1);
	}
}