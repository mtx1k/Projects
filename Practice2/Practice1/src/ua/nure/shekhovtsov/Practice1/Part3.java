package ua.nure.shekhovtsov.Practice1;

public class Part3 {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("not arguments!");
			System.exit(0);
		}
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int maxDivider;
		if(num1 < num2) {
			maxDivider = num1;
		}
		else {
			maxDivider = num2;
		}
		for (int i = maxDivider; i > 0; i--) {
			
			if(num1 % i == 0 && num2 % i == 0)
			{
				maxDivider = i;
				break;
			}			
		}
		System.out.println("Max devider of numbers " + args[0] + " and " + args[1] + " is: " + maxDivider);	
	}
}
