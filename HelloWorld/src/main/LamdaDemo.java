package main;

@FunctionalInterface
interface MyLambda{
	public void display();
}
@FunctionalInterface
interface MyLambda1{
	public void display(String str);
}
@FunctionalInterface
interface MyLambda2{
	public int add(int x,int y);
}


//no need of below class implementing functional interface
class MyClass implements MyLambda{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
	}
	
}

public class LamdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	MyClass class1 = new MyClass();
	//	class1.display();
		//isntead of creating annonymous calss we can use lambda expressions
		//below is an example of lambda expression wihtou parameter
		MyLambda lambda = () -> System.out.println("Hello");
		lambda.display();
		
		//below is an example with parameter
		MyLambda1 lambda1 = (s) -> System.out.println(s);
		lambda1.display("Hello World 1");

		
		
		//below is an example with two parameters
		MyLambda2 lambda2 = (a,b) -> {return a+b;};
		System.out.println(lambda2.add(10, 30));
		//result can be assigned to a variabl
		int r = lambda2.add(10, 10);
		System.out.println(r);
		
		// can be re written as follow, no need of return
		MyLambda2 lambda21 = (a,b) -> a+b;
		System.out.println(lambda21.add(5, 4));
		
		//Lambda exapression can be sent as parameter
		//CallLambda(lambda21);
		
		//directly calling a method with lambda expression as param
		CallLambda((a,b)->a-b);
	}
	
	public static void CallLambda(MyLambda2 lamda) {
		System.out.println(lamda.add(15, 4));
	}
	
	

}
