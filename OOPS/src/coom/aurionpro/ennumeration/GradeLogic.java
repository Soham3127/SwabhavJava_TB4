package coom.aurionpro.ennumeration;


public class GradeLogic {
	public void logicGrade(String input) {
		
		switch (input) {
		case"A":
			System.out.println("Grade A"+ Grade.A.getDescription());
			break;
		
		case"B":
			System.out.println("Grade A"+ Grade.B.getDescription());
			break;
			
		case"C":
			System.out.println("Grade A"+ Grade.C.getDescription());
			break;	
			
		case"D":
			System.out.println("Grade A"+ Grade.D.getDescription());
			break;
			
		case"F":
			System.out.println("Grade A"+ Grade.F.getDescription());
			break;	
			
		default:
			System.out.println("Inavlid Grade Entereed");
		}
	}
	

}
