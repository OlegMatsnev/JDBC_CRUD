package CRUD;


import org.example.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {


    public static Client readClientById(Connection connection, String id) throws SQLException {
        String tableName = "client";

        String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Client client = new Client(
                            resultSet.getString("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("date_of_birth"),
                            resultSet.getString("address"),
                            resultSet.getString("phone_number"),
                            resultSet.getString("email_address")
                    );
                    return client;
                } else {
                    return null; // Если запись с указанным id не найдена
                }
            }
        }
    }

    public static Account readAccountById(Connection connection, String id) throws SQLException {
        String tableName = "account";

        String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Account account = new Account(
                            resultSet.getString("id"),
                            resultSet.getDouble("balance"),
                            resultSet.getString("currency")
                    );
                    return account;
                } else {
                    return null; // Если запись с указанным id не найдена
                }
            }
        }
    }

    public static Credit readCreditById(Connection connection, String id) throws SQLException {
        String tableName = "credit";

        String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Credit credit = new Credit(
                            resultSet.getString("id"),
                            resultSet.getString("start_date"),
                            resultSet.getString("end_date"),
                            resultSet.getDouble("amount"),
                            resultSet.getDouble("interest_rate"),
                            resultSet.getString("currency")
                    );
                    return credit;
                } else {
                    return null; // Если запись с указанным id не найдена
                }
            }
        }
    }

    public static Deposit readDepositById(Connection connection, String id) throws SQLException {
        String tableName = "deposit";

        String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Deposit deposit = new Deposit(
                            resultSet.getString("id"),
                            resultSet.getString("start_date"),
                            resultSet.getString("end_date"),
                            resultSet.getDouble("amount"),
                            resultSet.getDouble("interest_rate"),
                            resultSet.getString("currency")
                    );
                    return deposit;
                } else {
                    return null; // Если запись с указанным id не найдена
                }
            }
        }
    }


    public static BankCard readBankCardById(Connection connection, String id) throws SQLException {
        String tableName = "bankcard";

        String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    BankCard bankCard = new BankCard(
                            resultSet.getString("id"),
                            resultSet.getString("card_number"),
                            resultSet.getString("card_holder_name"),
                            resultSet.getString("expiration_date"),
                            resultSet.getString("cvv")
                    );
                    return bankCard;
                } else {
                    return null; // Если запись с указанным id не найдена
                }
            }
        }
    }

    public static TransactionHistory readTransactionHistoryById(Connection connection, String id) throws SQLException {
        String tableName = "transactionhistory";

        String selectQuery = "SELECT * FROM " + tableName + " WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    TransactionHistory transactionHistory = new TransactionHistory(
                            resultSet.getString("id"),
                            resultSet.getDouble("totalTransactions"),
                            resultSet.getDouble("totalDeposits"),
                            resultSet.getDouble("totalWithdrawals"),
                            resultSet.getDouble("totalTransfers")
                    );
                    return transactionHistory;
                } else {
                    return null; // Если запись с указанным id не найдена
                }
            }
        }
    }


    public static void readTable(Connection connection, String tableName, int limit) throws SQLException {
        String[] attributes = getTableAttributes(tableName);

        String selectQuery = "SELECT * FROM " + tableName;

        if (limit > 0) {
            selectQuery += " LIMIT " + limit;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                for (String attribute : attributes) {
                    System.out.println(attribute + ": " + resultSet.getString(attribute));
                }
                System.out.println("------------------------");
            }
        }
    }

    private static String[] getTableAttributes(String tableName) {
        // Вернуть массив с именами атрибутов таблицы
        switch (tableName) {
            case "client":
                return new String[]{"id", "first_name", "last_name", "date_of_birth", "address", "phone_number", "email_address"};
            case "account":
                return new String[]{"id", "balance", "currency", "client_id"};
            case "credit":
                return new String[]{"id", "start_date", "end_date", "amount", "interest_rate", "currency", "client_id"};
            case "deposit":
                return new String[]{"id", "start_date", "end_date", "amount", "interest_rate", "currency", "client_id"};
            case "bankcard":
                return new String[]{"id", "card_number", "card_holder_name", "expiration_date", "cvv", "client_id"};
            case "transactionhistory":
                return new String[]{"id", "totalTransactions", "totalDeposits", "totalWithdrawals", "totalTransfers", "client_id"};
            default:
                throw new IllegalArgumentException("Invalid table name.");
        }
    }
}

