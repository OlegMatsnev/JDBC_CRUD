package CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Create {



    public static void createClient(Connection connection, Map<String, Object> attributes) throws SQLException {
        System.out.println("Creating a new client record:");

        String clientId = (String) attributes.get("clientId");

        // Запрос данных у пользователя
        String firstName = (String) attributes.get("firstName");
        String lastName = (String) attributes.get("lastName");

        // Пример запроса даты рождения с использованием формата "yyyy-MM-dd"
        String dateOfBirth = (String) attributes.get("dateOfBirth");

        String address = (String) attributes.get("address");
        String phoneNumber = (String) attributes.get("phoneNumber");
        String emailAddress = (String) attributes.get("emailAddress");

        // SQL-запрос для вставки данных в таблицу
        String insertClientQuery = "INSERT INTO client (id, first_name, last_name, date_of_birth, address, phone_number, email_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientQuery)) {
            preparedStatement.setString(1, clientId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, dateOfBirth);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, phoneNumber);
            preparedStatement.setString(7, emailAddress);

            // Выполнение SQL-запроса
            preparedStatement.executeUpdate();

            System.out.println("Client record created successfully!");
        }
    }


    public static void createAccount(Connection connection, Map<String, Object> attributes) throws SQLException {
        System.out.println("Creating a new account record:");

        String accountId = (String) attributes.get("accountId");
        double balance = (double) attributes.get("balance");
        String currency = (String) attributes.get("currency");
        String clientId = (String) attributes.get("clientId");

        // SQL-запрос для вставки данных в таблицу
        String insertAccountQuery = "INSERT INTO account (id, balance, currency, client_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountQuery)) {
            preparedStatement.setString(1, accountId);
            preparedStatement.setDouble(2, balance);
            preparedStatement.setString(3, currency);
            preparedStatement.setString(4, clientId);

            // Выполнение SQL-запроса
            preparedStatement.executeUpdate();

            System.out.println("Account record created successfully!");
        }
    }


    public static void createCredit(Connection connection, Map<String, Object> attributes) throws SQLException {
        try {
            System.out.println("Creating a new credit record.");


            String creditId = (String) attributes.get("creditId");

            // Get user input for other credit attributes
            String startDate = (String) attributes.get("startDate");
            String endDate = (String) attributes.get("endDate");
            double amount = (double) attributes.get("amount");
            double interestRate = (double) attributes.get("interestRate");
            String currency = (String) attributes.get("currency");
            String clientId = (String) attributes.get("clientId");

            // Prepare SQL statement
            String insertCreditQuery = "INSERT INTO credit (id, start_date, end_date, amount, interest_rate, currency, client_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            // Execute SQL statement
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertCreditQuery)) {
                preparedStatement.setString(1, creditId);
                preparedStatement.setString(2, startDate);
                preparedStatement.setString(3, endDate);
                preparedStatement.setDouble(4, amount);
                preparedStatement.setDouble(5, interestRate);
                preparedStatement.setString(6, currency);
                preparedStatement.setString(7, clientId);

                preparedStatement.executeUpdate();
                System.out.println("Credit record created successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error creating credit record: " + e.getMessage());
        }
    }


    public static void createDeposit(Connection connection, Map<String, Object> attributes) throws SQLException {
        // Generate a unique ID for the deposit
        String depositId = (String) attributes.get("depositId");

        // Request and validate other attributes
        String startDate = (String) attributes.get("startDate");
        String endDate = (String) attributes.get("endDate");
        double amount = (double) attributes.get("amount");
        double interestRate = (double) attributes.get("interestRate");
        String currency = (String) attributes.get("currency");
        String clientId = (String) attributes.get("clientId");

        // Prepare the SQL query
        String insertDepositQuery = "INSERT INTO deposit (id, start_date, end_date, amount, interest_rate, currency, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        // Execute the SQL query
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDepositQuery)) {
            preparedStatement.setString(1, depositId);
            preparedStatement.setString(2, startDate);
            preparedStatement.setString(3, endDate);
            preparedStatement.setDouble(4, amount);
            preparedStatement.setDouble(5, interestRate);
            preparedStatement.setString(6, currency);
            preparedStatement.setString(7, clientId);

            preparedStatement.executeUpdate();
            System.out.println("Deposit created successfully!");
        }
    }


    public static void createBankCard(Connection connection, Map<String, Object> attributes) throws SQLException {
        String cardId = (String) attributes.get("cardId");
        String cardNumber = (String) attributes.get("cardNumber");
        String cardHolderName = (String) attributes.get("cardHolderName");
        String expirationDate = (String) attributes.get("expirationDate");
        String cvv = (String) attributes.get("cvv");
        String clientId = (String) attributes.get("clientId");

        String insertBankCardQuery = "INSERT INTO bankcard (id, card_number, card_holder_name, expiration_date, cvv, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBankCardQuery)) {
            preparedStatement.setString(1, cardId);
            preparedStatement.setString(2, cardNumber);
            preparedStatement.setString(3, cardHolderName);
            preparedStatement.setString(4, expirationDate);
            preparedStatement.setString(5, cvv);
            preparedStatement.setString(6, clientId);

            preparedStatement.executeUpdate();
            System.out.println("Bank card created successfully!");
        }
    }


    public static void createTransactionHistory(Connection connection, Map<String, Object> attributes) throws SQLException {
        String transactionHistoryId = (String) attributes.get("transactionHistoryId");
        double totalTransactions = (double) attributes.get("totalTransactions");
        double totalDeposits = (double) attributes.get("totalDeposits");
        double totalWithdrawals = (double) attributes.get("totalWithdrawals");
        double totalTransfers = (double) attributes.get("totalTransfers");
        String clientId = (String) attributes.get("clientId");


        String insertTransactionHistoryQuery = "INSERT INTO transactionhistory (id, totalTransactions, totalDeposits, totalWithdrawals, totalTransfers, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertTransactionHistoryQuery)) {
            preparedStatement.setString(1, transactionHistoryId);
            preparedStatement.setDouble(2, totalTransactions);
            preparedStatement.setDouble(3, totalDeposits);
            preparedStatement.setDouble(4, totalWithdrawals);
            preparedStatement.setDouble(5, totalTransfers);
            preparedStatement.setString(6, clientId);

            preparedStatement.executeUpdate();
            System.out.println("Transaction history created successfully!");
        }
    }
}
