import java.util.Scanner;
class InvINN extends Exception {
    public InvINN(String message) {
        super(message);
    }
}
public class OnlinePurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите номер ИНН: ");
        String inn = scanner.nextLine();
        try {
            validateINN(inn);
            System.out.println("Заказ успешно оформлен на имя: " + fullName);
        } catch (InvINN e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
    public static void validateINN(String inn) throws InvINN {
        if (!inn.matches("\\d{10}") && !inn.matches("\\d{12}")) {
            throw new InvINN("ИНН должен содержать 10 или 12 цифр.");
        }
    }
}