
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        String input = scanner.nextLine();

        // Sanitize the input by removing leading/trailing spaces
        input = input.trim();

        try {
            double temperature = Double.parseDouble(input);

            System.out.println("Choose conversion option:");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            double convertedTemperature;

            if (choice == 1) {
                convertedTemperature = fahrenheitToCelsius(temperature);
                System.out.printf("%.2f°F is equivalent to %.2f°C", temperature, convertedTemperature);
            } else if (choice == 2) {
                convertedTemperature = celsiusToFahrenheit(temperature);
                System.out.printf("%.2f°C is equivalent to %.2f°F", temperature, convertedTemperature);
            } else {
                System.out.println("Invalid choice. Please select option 1 or 2.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numerical value.");
        }
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}

