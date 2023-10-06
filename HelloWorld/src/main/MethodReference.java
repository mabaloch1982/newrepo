package main;

@FunctionalInterface
interface functionalInterfaceExample{
	public void display(String str);
}
@FunctionalInterface
interface functionalInterfaceExample2{
	public void Calculate(int a, int b);
}
@FunctionalInterface
interface functionalInterfaceExample3{
	public int compare(String a, String b);
}

public class MethodReference {
	
	public static void reverse(String str) {
		StringBuffer buffer =  new StringBuffer(str);
		buffer.reverse();
		System.out.println(buffer);
	}
	
	public static void add(int a,int b) {
		System.out.println(a+b);
	}
	public static void multiply(int a,int b) {
		System.out.println(a*b);
	}
	/*
	 * public static void printResult(String a, String b) { System.out.println(a*b);
	 * }
	 */
	
	
	public static void main(String args[]) {
		
		functionalInterfaceExample ml = System.out::println;
		ml.display("Hello");
		
		functionalInterfaceExample m2 = MethodReference::reverse;
		m2.display("Asif");
		
		functionalInterfaceExample2 m3 = MethodReference::add;
		m3.Calculate(2, 2);
		
		functionalInterfaceExample2 m4 = MethodReference::multiply;
		m4.Calculate(2, 2);
		
		functionalInterfaceExample3 m5 = String::compareTo;
		System.out.println(m5.compare("asif", "asif0"));

	}

}
