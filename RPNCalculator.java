// Стек позволяет выполнять операции с последними добавленными элементами.
import java.util.Stack;
import java.util.Scanner;

public class RPNCalculator {

    // Метод для вычисления выражения в обратной польской нотации
    public static double evaluateRPN(String[] tokens) {
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    if (b == 0) {
                        throw new ArithmeticException("Деление на ноль!");
                    }
                    stack.push(a / b);
                    break;
                default:
                    // Если токен не является оператором, преобразуем его в число и добавляем в стек
                    stack.push(Double.parseDouble(token));
                    break;
            }
        }

        // Результат будет единственным элементом в стеке
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение в обратной польской нотации (например, '3 4 + 2 *'): ");
        String input = scanner.nextLine();

        // Разделяем входную строку на токены
        String[] tokens = input.split(" ");

        try {
            double result = evaluateRPN(tokens);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
