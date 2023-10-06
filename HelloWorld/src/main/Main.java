package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(List.of("Alpha","bravo","charlie","delta"));
	
		for (String s: list) {
			System.out.println(s);
		}
		System.out.println("-------------");
		//Alternative Lambda for above code
		list.forEach((myString)->System.out.println(myString));
		// Could be re written as follows but mentioing type is optional as Java implicityly figures out the type
		list.forEach((String myString)->System.out.println(myString));
		//no parenthesis required with single parameter
		list.forEach(myString->System.out.println(myString));
		
		System.out.println("-------------");
		
		list.forEach((var myString) -> {
			
			char first = myString.charAt(0);
			System.out.println(myString + " means " + first);
		});
	
		// calling a function using lambda
		int result = Calculator((a,b) -> a+b, 5,2);
		// follwoing is also valid
		int result2 = Calculator((Integer a, Integer b) -> a+b,5,2);
		// follwoing is also valid
		int result3 = Calculator((var a, var b) -> a+b,5,2);
		// follwoing is also valid
		int result4 = Calculator((var a, var b) -> a/b,5,2);
		// follwoing is also valid
		String result5  = Calculator((a,b)-> a.toUpperCase() + " " + b.toUpperCase(),"Ralph","Kramden");
		//return statement
		Double result6 = Calculator((Double a, Double b) -> a/b,5.0,2.0);
		//return statement
				Double result7 = Calculator((Double a, Double b) -> {Double c = a/b; return c;},5.0,2.0);
				
				var coords =  Arrays.asList(
						new double[] {47.2149, -95.2348},
						new double[] {29.2149, -89.2348},
						new double[] {35.2149, -90.2348}
						);
				
				coords.forEach(s -> System.out.println(Arrays.toString(s)));
	
	
				BiConsumer<Double, Double> p1 = (lat,lng) ->
				System.out.printf("[lat:%.3f lon:%.3f]%n",lat,lng);
				var firstPoint = coords.get(0);
				processPoint(firstPoint[0],firstPoint[1],p1);
				
				
				System.out.println("----------------");
				
				//coords.forEach(s -> processPoint(s[0],s[1],s[2]));
				
				//predicate Functions  with Lambda
				list.removeIf(s -> s.equalsIgnoreCase("bravo"));
				list.forEach(s -> System.out.println(s));
				
				list.addAll(List.of("echo","easy","earnest"));
				list.forEach(s -> System.out.println(s));
				
				list.removeIf(s -> s.equalsIgnoreCase("ea"));
				list.forEach(s -> System.out.println(s));
				
				String[] emptyStrings = new String[10];
				
				Arrays.setAll(emptyStrings,(i) -> ""+(i+1)+".");
				System.out.println(Arrays.toString(emptyStrings));
				
				Arrays.setAll(emptyStrings,(i) -> ""+(i+1)+"."
						
					+	switch (i) {
					case 0 -> "one";
					case 1 -> "two";
					case 2 -> "three";
					default -> "";
					}
						
						);
				
				System.out.println(Arrays.toString(emptyStrings));
				
				//Supplied Interface with Lambda
				
				String[] names = {"Ann", "Bob", "Carol", "David", "ED", "Fred"};
				String[] randomList = randomlySelectedValues(15,names,
						()->new Random().nextInt(0,names.length)						
						);
				
				System.out.println(Arrays.toString(randomList));
				
				
				//Method References i.e. Integer: sum system.out println
				
				List<String> newList = new ArrayList<>(List.of("Anna","Bob","Chunk","Dave"));
				newList.forEach(System.out::println);
				calculator((a,b)-> a+b, 10,25);
				//alternative of above line refernece method
				calculator(Integer::sum, 10,25);
				calculator(Double::sum, 2.5,7.5);
				
				Supplier<PlainOld> reference1 = () -> new PlainOld();
				//Alterative of above line is by method refernce as below
				Supplier<PlainOld> reference2 = PlainOld::new;// deferred method invocation not executed yet
				
				PlainOld newPojo = reference2.get();
				
				System.out.println("Getting Array");
				PlainOld[] pojo1 = PlainOld.seedArray(PlainOld::new, 10);
		
	}
	
	public static <T> T Calculator (Operation<T> function, T value1, T value2) {
		
		T result = function.operate(value1, value2);
		System.out.println("Result of Operation: " + result);
		return result;
	}
	
	
public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer) {
	consumer.accept(t1, t2);
}

public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s) {

	String[] selectedValues = new String[count];
	int i=0;
	for (String string : selectedValues) {
		selectedValues[i] = values[s.get()];
		//string= values[s.get()];
		i++;
	}
	return selectedValues;
	
}

private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
	
	T result = function.apply(value1, value2);
	System.out.println("Result of Operation" + result);
	
}


}
 

 class PlainOld{
	
	private static int last_id = 1;
	private int id;
	
	public PlainOld() {
		
		id = last_id++;
		System.out.println("Creating a PlainOld object: id = " + id);
	}
	
	public static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
		PlainOld[] array = new PlainOld[count];
		Arrays.setAll(array,i->reference.get());
		return array;
	}
	
	
}
