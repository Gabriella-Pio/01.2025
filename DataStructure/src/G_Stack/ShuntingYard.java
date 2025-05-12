package G_Stack;
import java.util.Scanner;
import java.util.Stack;

public class ShuntingYard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> operations = new Stack<>();

        StringBuilder answer = new StringBuilder();

        System.out.print("Digite uma operação: ");
        String operation = sc.nextLine();

        for(int i = 0; operation.length() > i; i++) {
            char current = operation.charAt(i);

            if (Character.isDigit(current)) { //se número -> imprime
                answer.append(current);
                continue;
            }

            if (String.valueOf(current).matches("\\+|\\-")) {
                operations.push(current);
            } else if (!operations.isEmpty() && operations.lastElement().toString().matches("\\*|\\/")
                    && String.valueOf(current).matches("\\+|\\-")) {
                answer.append(operations.pop());
                operations.push(current);
            }

            if (String.valueOf(current).matches("\\*|\\/") && (operations.isEmpty()||operations.lastElement().toString().matches("\\-|\\+") )){
                operations.push(current);
            } else if (!operations.isEmpty() && operations.lastElement().toString().matches("\\*|\\/")
                    && String.valueOf(current).matches("\\*|\\/")) {
                answer.append(operations.pop());
                operations.push(current);
            }

            if (String.valueOf(current).matches("\\(")) {
                operations.push(current);
            } else if (String.valueOf(current).matches("\\)")) {
                answer.append(operations.pop());
                operations.pop();
            }
        }

        for(Character character : operations) {
            answer.append(character);
        }
        System.out.println(answer.toString());
    }
}
