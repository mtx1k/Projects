package ua.nure.shekhovtsov.Practice1;

public class Part2 {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("not arguments!");
			System.exit(0);
		}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		System.out.println(args[0] + " + " + args[1] + " = " + (num1 + num2));		
	}
}