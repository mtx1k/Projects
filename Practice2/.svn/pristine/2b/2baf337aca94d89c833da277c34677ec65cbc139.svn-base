package ua.nure.Shekhovtsov.Practice2;

import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
		System.out.println("Part1");
		MyListImpl con = new MyListImpl();
		con.add("A");
		con.add("B");
		con.add(433);
		con.add(888);
		con.add(new Object());
		System.out.println(con.toString());
		con.remove("B");
		System.out.println(con.toString());
		System.out.println(con.contains("A"));
		MyListImpl con2 = new MyListImpl();
		con2.add("A");
		con2.add(888);
		con2.add(433);
		System.out.println(con.containsAll(con2));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println("Part2");
		for (Object o : con) {
		    System.out.print(o + " ");
		}
		System.out.println();
		Iterator<Object> it = con.iterator();
		int i = 0;
		while (it.hasNext()) {
			i++;
			it.next();
		    if(i==2) {
		    	it.remove();
		    }
		}
		it = con.iterator();
		while (it.hasNext()) {
		    System.out.print(it.next() + " ");
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		System.out.println("Part3");
		con.add("B");
		con.add(433);
		ListIterator it2 = con.listIterator();
		while (it2.hasPrevious()) {
		    System.out.print(it2.previous() + " ");
		}
		System.out.println();
		it2 = con.listIterator();
		i = con.size();
		while (it2.hasPrevious()) {
			i--;
			it2.previous();
		    if(i==2) {
		    	it2.remove();
		    }
		}
		it2 = con.listIterator();
		while (it2.hasPrevious()) {
		    System.out.print(it2.previous() + " ");
		}
		System.out.println();
	}
}


