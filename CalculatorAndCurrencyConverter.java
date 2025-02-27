package Task;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorAndCurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Currency Converter");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                arithmeticOperations(scanner);
            } else if (choice == 2) {
                currencyConverter(scanner);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        scanner.close();
    }

    // Method for arithmetic operations
    public static void arithmeticOperations(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter an operator (+, -, *, /, %): ");
        char operator = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0;
        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': 
                if (num2 != 0) result = num1 / num2; 
                else { System.out.println("Error: Division by zero!"); return; }
                break;
            case '%': result = num1 % num2; break;
            default: 
                System.out.println("Invalid operator!"); return;
        }

        System.out.println("Result: " + result);
    }

    // Method for currency conversion
    public static void currencyConverter(Scanner scanner) {
        // Predefined exchange rates (relative to 1 USD)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.92);
        exchangeRates.put("INR", 87.3247);
        exchangeRates.put("GBP", 0.78);
        exchangeRates.put("JPY", 150.3);
        exchangeRates.put("CAD", 1.35);
        exchangeRates.put("AUD", 1.52);
        exchangeRates.put("CNY", 7.2);
        exchangeRates.put("SGD", 1.35);
        exchangeRates.put("AED", 3.67);

        System.out.println("\nSupported Currencies: USD, EUR, INR, GBP, JPY, CAD, AUD, CNY, SGD, AED");
        System.out.print("Enter base currency: ");
        String fromCurrency = scanner.next().toUpperCase();
        System.out.print("Enter target currency: ");
        String toCurrency = scanner.next().toUpperCase();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        // Validate currency input
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            System.out.println("Conversion not available for given currencies.");
            return;
        }

        // Convert amount to USD first, then to target currency
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        double convertedAmount = amountInUSD * exchangeRates.get(toCurrency);

        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, toCurrency);
    }
}
