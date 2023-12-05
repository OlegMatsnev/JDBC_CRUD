package console_utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class CreateUtils {

    public static Map<String, Object> collectClientData(Scanner scanner) {
        System.out.println("Creating a new client record:");

        // Генерируем ID клиента
        String clientId = UUID.randomUUID().toString();

        // Запрос данных у пользователя
        String firstName = General.getUserInput2(scanner, "Enter first name", "[A-Za-z]+");
        String lastName = General.getUserInput2(scanner, "Enter last name", "[A-Za-z]+");

        // Пример запроса даты рождения с использованием формата "yyyy-MM-dd"
        String dateOfBirthStr = General.getUserInput2(scanner, "Enter date of birth (yyyy-MM-dd)", "\\d{4}-\\d{2}-\\d{2}");

        String address = General.getUserInput2(scanner, "Enter address", ".+");
        String phoneNumber = General.getUserInput2(scanner, "Enter phone number", "\\d{10,15}");
        String emailAddress = General.getUserInput2(scanner, "Enter email address", "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}");

        // Создаем Map с собранными данными
        Map<String, Object> clientData = new HashMap<>();
        clientData.put("clientId", clientId);
        clientData.put("firstName", firstName);
        clientData.put("lastName", lastName);
        clientData.put("dateOfBirth", dateOfBirthStr);
        clientData.put("address", address);
        clientData.put("phoneNumber", phoneNumber);
        clientData.put("emailAddress", emailAddress);

        return clientData;
    }


    public static Map<String, Object> collectAccountData(Scanner scanner) {
        System.out.println("Creating a new account record:");

        Map<String, Object> accountData = new HashMap<>();

        // Запрос ID клиента, для которого создается счет
        String clientId = General.getUserInput2(scanner, "Enter client ID", "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");
        accountData.put("clientId", clientId);

        // Запрос данных у пользователя
        String accountId = UUID.randomUUID().toString();
        double balance = General.getUserInputAsDouble(scanner, "Enter balance");
        String currency = General.getUserInput2(scanner, "Enter currency", ".+");

        // Добавляем данные в Map
        accountData.put("accountId", accountId);
        accountData.put("balance", balance);
        accountData.put("currency", currency);

        return accountData;
    }


    public static Map<String, Object> collectCreditData(Scanner scanner) {
        System.out.println("Creating a new credit record:");

        Map<String, Object> creditData = new HashMap<>();

        // Generate UUID for the credit
        String creditId = UUID.randomUUID().toString();

        // Get user input for other credit attributes
        String startDate = General.getUserInput2(scanner, "Enter start date (yyyy-mm-dd):", null);
        String endDate = General.getUserInput2(scanner, "Enter end date (yyyy-mm-dd):", null);
        double amount = General.getUserInputAsDouble(scanner, "Enter credit amount");
        double interestRate = General.getUserInputAsDouble(scanner, "Enter interest rate");
        String currency = General.getUserInput2(scanner, "Enter currency:", null);
        String clientId = General.getUserInput2(scanner, "Enter client ID", "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");

        // Добавляем данные в Map
        creditData.put("creditId", creditId);
        creditData.put("startDate", startDate);
        creditData.put("endDate", endDate);
        creditData.put("amount", amount);
        creditData.put("interestRate", interestRate);
        creditData.put("currency", currency);
        creditData.put("clientId", clientId);

        return creditData;
    }


    public static Map<String, Object> collectDepositData(Scanner scanner) {
        System.out.println("Creating a new deposit record:");

        Map<String, Object> depositData = new HashMap<>();

        // Generate a unique ID for the deposit
        String depositId = UUID.randomUUID().toString();

        // Request and validate other attributes
        String startDate = General.getUserInput2(scanner, "Enter start date (yyyy-mm-dd)", "\\d{4}-\\d{2}-\\d{2}");
        String endDate = General.getUserInput2(scanner, "Enter end date (yyyy-mm-dd)", "\\d{4}-\\d{2}-\\d{2}");
        double amount = General.getUserInputAsDouble(scanner, "Enter credit amount");
        double interestRate = General.getUserInputAsDouble(scanner, "Enter interest rate");
        String currency = General.getUserInput2(scanner, "Enter currency:", null);
        String clientId = General.getUserInput2(scanner, "Enter client ID", "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");

        // Добавляем данные в Map
        depositData.put("depositId", depositId);
        depositData.put("startDate", startDate);
        depositData.put("endDate", endDate);
        depositData.put("amount", amount);
        depositData.put("interestRate", interestRate);
        depositData.put("currency", currency);
        depositData.put("clientId", clientId);

        return depositData;
    }


    public static Map<String, Object> collectBankCardData(Scanner scanner) {
        System.out.println("Creating a new bank card record:");

        Map<String, Object> bankCardData = new HashMap<>();

        // Generate a unique ID for the bank card
        String cardId = UUID.randomUUID().toString();

        // Request and validate other attributes
        String cardNumber = General.getUserInput2(scanner, "Enter card number", ".+");
        String cardHolderName = General.getUserInput2(scanner, "Enter card holder name", ".+");
        String expirationDate = General.getUserInput2(scanner, "Enter expiration date", ".+");
        String cvv = General.getUserInput2(scanner, "Enter CVV", ".+");
        String clientId = General.getUserInput2(scanner, "Enter client ID", "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");

        // Добавляем данные в Map
        bankCardData.put("cardId", cardId);
        bankCardData.put("cardNumber", cardNumber);
        bankCardData.put("cardHolderName", cardHolderName);
        bankCardData.put("expirationDate", expirationDate);
        bankCardData.put("cvv", cvv);
        bankCardData.put("clientId", clientId);

        return bankCardData;
    }



    public static Map<String, Object> collectTransactionHistoryData(Scanner scanner) {
        System.out.println("Creating a new transaction history record:");

        Map<String, Object> transactionHistoryData = new HashMap<>();

        // Generate a unique ID for the transaction history
        String transactionHistoryId = UUID.randomUUID().toString();

        // Request and validate other attributes
        double totalTransactions = General.getUserInputAsDouble(scanner, "Enter total transactions");
        double totalDeposits = General.getUserInputAsDouble(scanner, "Enter total deposits");
        double totalWithdrawals = General.getUserInputAsDouble(scanner, "Enter total withdrawals");
        double totalTransfers = General.getUserInputAsDouble(scanner, "Enter total transfers");
        String clientId = General.getUserInput2(scanner, "Enter client ID", "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");

        // Добавляем данные в Map
        transactionHistoryData.put("transactionHistoryId", transactionHistoryId);
        transactionHistoryData.put("totalTransactions", totalTransactions);
        transactionHistoryData.put("totalDeposits", totalDeposits);
        transactionHistoryData.put("totalWithdrawals", totalWithdrawals);
        transactionHistoryData.put("totalTransfers", totalTransfers);
        transactionHistoryData.put("clientId", clientId);

        return transactionHistoryData;
    }


}
