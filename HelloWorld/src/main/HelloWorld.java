package main;

public class HelloWorld {

	public static void main(String args[]) {
	
		int x=0,y=0,z=0;
		
		 x = 5 ;
		System.out.println("x = "+ x + " y = "+ y + " z = "+ z);

		y = ++x;
		System.out.println("x = "+ x + " y = "+ y + " z = "+ z);
		z = y++;				
		
		System.out.println("x = "+ x + " y = " + y + " z = "+ z);
	}
	
}
