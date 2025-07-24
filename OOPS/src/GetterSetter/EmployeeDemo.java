package GetterSetter;
import java.util.Scanner;

public class EmployeeDemo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.print("Enter employee name: ");
        emp.setName(scanner.nextLine());

        System.out.print("Enter salary: ");
        emp.setSalary(scanner.nextDouble());

        System.out.print("Enter bonus: ");
        emp.setBonus(scanner.nextDouble());

        emp.showSalary();
        emp.showFinalSalary();
        scanner.close();
    }
}