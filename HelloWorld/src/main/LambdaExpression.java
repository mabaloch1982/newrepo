package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

	
	record Person(String firstName, String lastName) {

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return firstName.concat(lastName);
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>(Arrays.asList(
				new LambdaExpression.Person("Lucy", "Vab Pelt"),
				new Person("Sally","Brown"),
				new Person("Linus","Van Pelt"),
				new Person("Peppermint","Patty"),
				new Person("Charlie","Brown")
				)); 
		
		//var comparatorLastName =
		 people.sort(new Comparator<Person>() {

			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.lastName().compareTo(o2.lastName());
			}

		});
		
		//replacement of above lines with below lambda expression

		people.sort((o1,o2)->o1.lastName().compareTo(o2.lastName));
		
		System.out.println(people);
		
		
		
		//Since Java 16 we can delclar interace inside a class
		//@FunctionalInterface
		interface EnhancedComparator<T> extends Comparator<T>{
			
			int secondLevel(T o1, T o2);
		}
		var comparatorMixed = new EnhancedComparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int result = o1.lastName().compareTo(o2.lastName());
				return (result == 0 ? secondLevel(o1,o2) : result);
			}

			@Override
			public int secondLevel(Person o1, Person o2) {
				return o1.firstName().compareTo(o2.firstName);
			}
			
		};
		
		people.sort(comparatorMixed);
		System.out.println(people);
		
	}
	
}
