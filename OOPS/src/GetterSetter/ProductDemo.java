package GetterSetter;
import java.util.Scanner;

public class ProductDemo {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.print("Enter product ID: ");
        product.setId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter product name: ");
        product.setName(scanner.nextLine());

        System.out.print("Enter product price: ");
        product.setPrice(scanner.nextDouble());

        product.showProduct();
        scanner.close();
    }
}



