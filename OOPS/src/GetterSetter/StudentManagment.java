package GetterSetter;
import java.util.Scanner;

public class StudentManagment{
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Student[] students = new Student[2];

    for (int i = 0; i < students.length; i++) {
        students[i] = new Student();

        System.out.print("Enter name: ");
        students[i].setName(scanner.nextLine());

        System.out.print("Enter roll number: ");
        students[i].setRollNo(scanner.nextInt());

        System.out.print("Enter marks (0-100): ");
        students[i].setMarks(scanner.nextInt());
        scanner.nextLine(); // consume newline
    }

    System.out.println("\nStudent Details:");
    for (Student s : students) {
        System.out.println("Name: " + s.getName() +
                           ", Roll No: " + s.getRollNo() +
                           ", Marks: " + s.getMarks());
    }

    scanner.close();
}
}
