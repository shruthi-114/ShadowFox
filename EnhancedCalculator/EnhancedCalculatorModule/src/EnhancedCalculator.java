import java.util.Scanner;

public class EnhancedCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Smart Calculator!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1 - Arithmetic Operations");
            System.out.println("2 - Scientific Functions");
            System.out.println("3 - Convert Temperature");
            System.out.println("4 - Convert Currency");
            System.out.println("5 - Exit");

            System.out.print("Your choice: ");
            int menu = input.nextInt();

            switch (menu) {
                case 1 -> performArithmetic(input);
                case 2 -> useScientificMode(input);
                case 3 -> convertTemperature(input);
                case 4 -> convertCurrency(input);
                case 5 -> {
                    System.out.println("Closing calculator. Goodbye!");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid selection. Try again.");
            }
        }
    }

    public static void performArithmetic(Scanner in) {
        System.out.print("Enter first number: ");
        double x = in.nextDouble();
        System.out.print("Enter second number: ");
        double y = in.nextDouble();
        System.out.print("Choose (+, -, *, /): ");
        String operation = in.next();

        switch (operation) {
            case "+" -> System.out.println("Answer: " + (x + y));
            case "-" -> System.out.println("Answer: " + (x - y));
            case "*" -> System.out.println("Answer: " + (x * y));
            case "/" -> {
                if (y != 0)
                    System.out.println("Answer: " + (x / y));
                else
                    System.out.println("Division by zero is not allowed.");
            }
            default -> System.out.println("Unknown operator.");
        }
    }

    public static void useScientificMode(Scanner in) {
        System.out.print("Enter number one: ");
        double a = in.nextDouble();
        System.out.print("Enter number two: ");
        double b = in.nextDouble();
        System.out.print("Choose function (^ or sqrt): ");
        String mode = in.next();

        switch (mode) {
            case "^" -> System.out.println("Result: " + Math.pow(a, b));
            case "sqrt" -> {
                System.out.println("Square root of first: " + Math.sqrt(a));
                System.out.println("Square root of second: " + Math.sqrt(b));
            }
            default -> System.out.println("Unsupported function.");
        }
    }

    public static void convertTemperature(Scanner in) {
        System.out.print("Convert (1: C to F, 2: F to C): ");
        int option = in.nextInt();

        if (option == 1) {
            System.out.print("Temperature in Celsius: ");
            double c = in.nextDouble();
            double f = (c * 9 / 5) + 32;
            System.out.println("In Fahrenheit: " + f);
        } else if (option == 2) {
            System.out.print("Temperature in Fahrenheit: ");
            double f = in.nextDouble();
            double c = (f - 32) * 5 / 9;
            System.out.println("In Celsius: " + c);
        } else {
            System.out.println("Invalid option.");
        }
    }

    public static void convertCurrency(Scanner in) {
        double rate = 83.0;
        System.out.println("Current Rate: 1 USD = 83.0 INR");
        System.out.print("Convert (1: INR to USD, 2: USD to INR): ");
        int option = in.nextInt();

        if (option == 1) {
            System.out.print("Amount in INR: ");
            double inr = in.nextDouble();
            double usd = inr / rate;
            System.out.printf("Converted to USD: %.2f\n", usd);
        } else if (option == 2) {
            System.out.print("Amount in USD: ");
            double usd = in.nextDouble();
            double inr = usd * rate;
            System.out.printf("Converted to INR: %.2f\n", inr);
        } else {
            System.out.println("Invalid conversion type.");
        }
    }
}
