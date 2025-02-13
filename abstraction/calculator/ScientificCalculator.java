import java.util.Scanner;

public class ScientificCalculator {
    private Scanner scanner = new Scanner(System.in);

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }

    public double sine(double angle) {
        return Math.sin(angle);
    }

    public double cosine(double angle) {
        return Math.cos(angle);
    }

    public double tangent(double angle) {
        return Math.tan(angle);
    }

    public double degreesToRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    public double radiansToDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    public double naturalLog(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Cannot calculate logarithm of non-positive number");
        }
        return Math.log(number);
    }

    public double log10(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Cannot calculate logarithm of non-positive number");
        }
        return Math.log10(number);
    }

    private double memory = 0;

    public void memorySave(double value) {
        this.memory = value;
    }

    public double memoryRecall() {
        return this.memory;
    }

    public void memoryClear() {
        this.memory = 0;
    }

    public void displayMenu() {
        System.out.println("\n=== Scientific Calculator ===");
        System.out.println("1. Basic Arithmetic");
        System.out.println("2. Power Operations");
        System.out.println("3. Trigonometric Functions");
        System.out.println("4. Logarithmic Operations");
        System.out.println("5. Memory Operations");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void handleBasicArithmetic() {
        System.out.println("\n=== Basic Arithmetic ===");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();
        
        double result = 0;
        switch (choice) {
            case 1:
                result = add(a, b);
                System.out.printf("%.2f + %.2f = %.2f%n", a, b, result);
                break;
            case 2:
                result = subtract(a, b);
                System.out.printf("%.2f - %.2f = %.2f%n", a, b, result);
                break;
            case 3:
                result = multiply(a, b);
                System.out.printf("%.2f × %.2f = %.2f%n", a, b, result);
                break;
            case 4:
                try {
                    result = divide(a, b);
                    System.out.printf("%.2f ÷ %.2f = %.2f%n", a, b, result);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void handlePowerOperations() {
        System.out.println("\n=== Power Operations ===");
        System.out.println("1. Power");
        System.out.println("2. Square Root");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        double result = 0;
        
        switch (choice) {
            case 1:
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                double exponent = scanner.nextDouble();
                result = power(base, exponent);
                System.out.printf("%.2f^%.2f = %.2f%n", base, exponent, result);
                break;
            case 2:
                System.out.print("Enter number: ");
                double number = scanner.nextDouble();
                try {
                    result = squareRoot(number);
                    System.out.printf("√%.2f = %.2f%n", number, result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void handleTrigonometric() {
        System.out.println("\n=== Trigonometric Functions ===");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        System.out.print("Enter angle in degrees: ");
        double angleDegrees = scanner.nextDouble();
        double angleRadians = degreesToRadians(angleDegrees);
        
        switch (choice) {
            case 1:
                System.out.printf("sin(%.2f°) = %.2f%n", angleDegrees, sine(angleRadians));
                break;
            case 2:
                System.out.printf("cos(%.2f°) = %.2f%n", angleDegrees, cosine(angleRadians));
                break;
            case 3:
                System.out.printf("tan(%.2f°) = %.2f%n", angleDegrees, tangent(angleRadians));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void handleLogarithmic() {
        System.out.println("\n=== Logarithmic Operations ===");
        System.out.println("1. Natural Logarithm (ln)");
        System.out.println("2. Logarithm base 10 (log10)");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        System.out.print("Enter number: ");
        double number = scanner.nextDouble();
        
        try {
            switch (choice) {
                case 1:
                    System.out.printf("ln(%.2f) = %.2f%n", number, naturalLog(number));
                    break;
                case 2:
                    System.out.printf("log10(%.2f) = %.2f%n", number, log10(number));
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void handleMemory() {
        System.out.println("\n=== Memory Operations ===");
        System.out.println("1. Store number in memory");
        System.out.println("2. Recall number from memory");
        System.out.println("3. Clear memory");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Enter number to store: ");
                double number = scanner.nextDouble();
                memorySave(number);
                System.out.println("Number stored in memory");
                break;
            case 2:
                System.out.printf("Number in memory: %.2f%n", memoryRecall());
                break;
            case 3:
                memoryClear();
                System.out.println("Memory cleared");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                System.out.println("Thank you for using the Scientific Calculator!");
                break;
            }
            
            switch (choice) {
                case 1:
                    handleBasicArithmetic();
                    break;
                case 2:
                    handlePowerOperations();
                    break;
                case 3:
                    handleTrigonometric();
                    break;
                case 4:
                    handleLogarithmic();
                    break;
                case 5:
                    handleMemory();
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        ScientificCalculator calculator = new ScientificCalculator();
        calculator.run();
    }
}