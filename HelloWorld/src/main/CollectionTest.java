package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = new ArrayList<>();
		//above line could be repalced as below
		//Collection<String> list = new HashSet<>();
		//Collection<String> list = new TreeSet<>();//sorted
		
		String[] names = {"Anna", "Bob", "Carol", "David","Edna"};
		list.addAll(Arrays.asList(names));
		System.out.println(list);
		
		list.add("Fred");
		list.addAll(Arrays.asList("George","Gary","Grace"));
		System.out.println(list);
		System.out.println("Gray is in the list? " + list.contains("Gary"));
		
		list.removeIf(t -> t.charAt(0)=='G');
		System.out.println(list);
		System.out.println("Gray is in the list? " + list.contains("Gary"));
		
		//Comparator<T> comparator = new Comparator<T>() {
		
			
		}
	

}
