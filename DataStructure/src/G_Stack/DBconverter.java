package G_Stack;
import java.util.Scanner;
import java.util.Stack;

public class DBconverter {
    public static void main(String[] args) {
        Stack<Integer> left = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the decimal number: ");
        int number = sc.nextInt();

        while (number >= 1) {
            System.out.println("Number is " + number);
            int div = number % 2;
            number = number / 2;
            System.out.println("New number: " + number);

            left.push(div);
            System.out.println("Binary: " + left.pop());
        }
        System.out.println("Binary: " + number);
    }
}
