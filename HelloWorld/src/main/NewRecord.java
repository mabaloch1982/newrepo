package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public record NewRecord(String id, String name) {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		NewRecord newRecord = new NewRecord("001", "Asif");
		
		System.out.println("Id: " + newRecord.id());
		
		System.out.println("Print: " + newRecord);
		
		int i=0;
		i++;
		System.out.println(i);
		++i;
		System.out.println(i);
		String s="";
		
		 s = String.join("-","Asif","Baloch","Muhammad","Nawal");
		System.out.println(s);
		
		String[] arrayString = new String[5];
		String[] annonymousArray= {"0","1"};
		System.out.println(Arrays.toString(annonymousArray));
		
		arrayString[0]="asif";
		
		int[] integerArray;
		String testArray[];
		int[] integerArray1 = new int[10];
		integerArray1[9]=1;
		
		
		for (int j : integerArray1) {
			System.out.println(integerArray1[j]);	
		}
		
		int[] firstArray = getRandomArray(10);
		System.out.println(Arrays.toString(firstArray));
		Arrays.sort(firstArray);
		System.out.println(Arrays.toString(firstArray));
		
		System.out.println(Arrays.binarySearch(firstArray, 10));
		
		var abc="";
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Asif");
		list.add("Baloch");
		Iterator<String> iterator = list.iterator();
		for (String string : list) {
			System.out.println(string);
		} 
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		DayOfTheWeek dayOfTheWeek = DayOfTheWeek.TUES;
		System.out.println(dayOfTheWeek);
		
		/*
		while(Arrays.binarySearch(firstArray, 10)<=0) {
			int[] secondArray = getRandomArray(10);
			Arrays.sort(secondArray);
			System.out.println(Arrays.toString(secondArray));
		}*/
		
		
		
	}

	private static int[] getRandomArray(int len) {
		
		Random random  = new Random();
		int[] newInt = new int[len];
		int j=0;
		for (int i : newInt) {
		
			newInt[j] = random.nextInt(100);
			j+=1;
		}
		
		return newInt;
		
	}
	
}
