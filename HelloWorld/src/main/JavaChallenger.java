package main;

public class JavaChallenger {
	
	public static void main(String args[]) {
		
		StringBuilder warriorProfession = new StringBuilder("Dragon ");
		String warriorWeapon = "Sword ";
		changeWarriorClass(warriorProfession,warriorWeapon);
		
		System.out.println("Warrior = "+ warriorProfession + " Weapon = " +warriorWeapon );
	}

	private static void changeWarriorClass(StringBuilder warriorProfession, String warriorWeapon) {
		// TODO Auto-generated method stub
		warriorProfession.append("Knight");
		warriorWeapon  = "Dragon " + warriorWeapon;
		
		warriorWeapon = null;
		warriorProfession = null;
			
		
		
	}

}

 class Numbers {

    static int[] s_ccc = {7};
    static int[] t_ccc = {7};

    public static void calculate(int[] b, int[] c) {

        System.out.println("s_ccc[0] = " + s_ccc[0]); // 7
        System.out.println("t_ccc[0] = " + t_ccc[0]); // 7

        b[0] = b[0] + 9;  
        System.out.println("\nb[0] = " + b[0]); // 16

        c = b;
        System.out.println("c[0] = " + c[0] + "\n"); // 16
    }

    public static void main(String[] args) {

        calculate(s_ccc, t_ccc);

        System.out.println("s_ccc[0] = " + s_ccc[0]);  // 16
        System.out.println("t_ccc[0] = " + t_ccc[0]);  // 7 
    }
}
