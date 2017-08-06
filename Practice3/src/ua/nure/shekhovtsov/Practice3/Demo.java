package ua.nure.shekhovtsov.Practice3;

import java.security.NoSuchAlgorithmException;

public class Demo {
	private static final String INPUT = "Login;Name;Email\n"
			+ "ivanov;Ivan Ivanov;ivanov@mail.ru\n"
			+ "petrov;Petr Petrov;petrov@google.com\n"
			+ "obama;Barack Obama;obama@google.com\n"
			+ "bush;George Bush;bush@mail.ru";

	private static final String INPUT2 = "When I was younger, so much younger than today\n"
			+ "I never needed anybody's help in any way\n"
			+ "But now these days are gone, I'm not so self-assured\n"
			+ "Now I find I've changed my mind\n" + "I've opened up the doors";

	private static final String INPUT3 = "Мама мыла раму\n"
			+ "Папа мыл машину\n";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("Part1");

		System.out.println(Part1.convert1(INPUT));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(Part1.convert2(INPUT));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(Part1.convert3(INPUT));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(Part1.convert4(INPUT));

		System.out.println("\nPart2");
		Part2.string2words(INPUT2);
		Part2.print();

		System.out.println("\nPart3");
		System.out.println(Part3.first2ApperCase(INPUT3));

		System.out.println("\nPart4");
		Part4.main(new String[0]);

		System.out.println("\nPart4");
		for (int i = 1; i <= 100; i++) {
			Part5 p5 = new Part5(i);
			System.out.println(i + " ====> " + p5.toString() + " ====> "
					+ p5.toInt());
		}
	}
}