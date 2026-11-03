import java.util.*;
import java.util.function.UnaryOperator;

public class DiscountEngine {

    public static void main(String[] args) {

        List<Double> prices = List.of(100.0, 250.0, 500.0);

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("1. 10% discount  2. Flat Rs. 20 off");
            System.out.print("Choose rule: ");

            int choice = sc.nextInt();

            UnaryOperator<Double> rule = switch (choice) {
                case 1 -> p -> p * 0.90;
                case 2 -> p -> Math.max(0, p - 20);
                default -> p -> p;
            };

            for (double p : prices) {
                System.out.println(p + " -> " + rule.apply(p));
            }
        }
    }
}