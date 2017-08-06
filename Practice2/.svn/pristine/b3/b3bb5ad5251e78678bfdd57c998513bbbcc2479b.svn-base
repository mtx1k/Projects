package ua.nure.shekhovtsov.Practice1;

public class Part4 {
	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("not arguments!");
			System.exit(0);
		}
		int number = Integer.parseInt(args[0]);
		int sum = 0;
		for(long i = 10; i < Integer.MAX_VALUE; i*=10l)
		{			
			sum += (number % i)/(i/10);
		}
		System.out.println("the sum of the digits of " + args[0] + " is: " + sum);
	}
}
