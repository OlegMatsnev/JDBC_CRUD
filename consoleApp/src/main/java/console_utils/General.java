package console_utils;

import org.example.AppCRUD;

import java.util.Scanner;

public class General {

    public static Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public static String getUserInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine().trim();
    }

    public static int getUserInputAsInt(String prompt) {
        while (true) {
            try {
                String userInput = getUserInput(prompt);
                return Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }


    public static String getUserInput2(Scanner scanner, String prompt, String regex) {
        String input;
        boolean isValid;

        do {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim();

            // Check if regex is not null before using it
            isValid = regex == null || input.matches(regex);

            if (!isValid) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!isValid);

        return input;
    }

    public static int getTableNum(Scanner scanner) {
        while (true) {
            tablesMenu();
            System.out.print("Введите номер таблицы: ");

            String input = scanner.nextLine().trim();

            try {
                int tableChoice = Integer.parseInt(input);

                if (tableChoice >= 1 && tableChoice <= 6) {
                    return tableChoice;
                } else {
                    System.out.println("Неправильный выбор номера таблицы! Введите число от 1 до 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат ввода! Введите число от 1 до 6.");
            }
        }
    }

    public static double getUserInputAsDouble(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }


    public static String getTableNameByChoice(int tableChoice) {
        return switch (tableChoice) {
            case 1 -> "client";
            case 2 -> "account";
            case 3 -> "credit";
            case 4 -> "deposit";
            case 5 -> "bankcard";
            case 6 -> "transactionhistory";
            default -> throw new IllegalArgumentException("Invalid table number.");
        };
    }

    public static void displayMenu() {
        System.out.println("Select operation:");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
    }


    public static void tablesMenu() {
        System.out.println("Choose a table:");
        System.out.println("1. Client");
        System.out.println("2. Account");
        System.out.println("3. Credit");
        System.out.println("4. Deposit");
        System.out.println("5. Bank card");
        System.out.println("6. Transaction history");
        System.out.print("Enter the number of the table: ");
    }
}
