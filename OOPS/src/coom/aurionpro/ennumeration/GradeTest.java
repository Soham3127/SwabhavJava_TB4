package coom.aurionpro.ennumeration;
import java.util.Scanner;

public class GradeTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		GradeLogic logic = new GradeLogic();
		
		System.out.print("Enetr Grade (A,B,C,D,F): ");
		String input = scanner.next().toUpperCase();
		
		logic.logicGrade(input);
	}

}
