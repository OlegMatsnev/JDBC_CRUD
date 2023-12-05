package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.example.DatabaseInitializer.getConnection;

public class DatabasePopulator {

    public static void fillTables() {
        System.out.println("Main deserialization is started");

        String inputPath = "deserialization/src/main/java/org/example/clients.json";

        JsonDeserializer jsonDeserializer = new JsonDeserializer();
        List<Client> clients = jsonDeserializer.deserializeFromJson(inputPath);

        try (Connection connection = getConnection()) {
            for (Client client : clients) {
                insertClient(connection, client);
                insertAccounts(connection, client);
                insertBankCards(connection, client);
                insertCredits(connection, client);
                insertDeposits(connection, client);
                insertTransactionHistories(connection, client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void insertClient(Connection connection, Client client) throws SQLException {
        String insertClientQuery = "INSERT INTO client (id, first_name, last_name, date_of_birth, address, phone_number, email_address) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertClientQuery)) {
            preparedStatement.setString(1, client.id);
            preparedStatement.setString(2, client.firstName);
            preparedStatement.setString(3, client.lastName);
            preparedStatement.setString(4, client.dateOfBirth);
            preparedStatement.setString(5, client.address);
            preparedStatement.setString(6, client.phoneNumber);
            preparedStatement.setString(7, client.emailAddress);

            preparedStatement.executeUpdate();
        }
    }


    private static void insertAccounts(Connection connection, Client client) throws SQLException {
        String insertAccountQuery = "INSERT INTO account (id, balance, currency, client_id) " +
                "VALUES (?, ?, ?, ?)";

        List<Account> accounts = client.accounts; // предположим, что у вас есть атрибут accounts в классе Client

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountQuery)) {
            for (Account account : accounts) {
                preparedStatement.setString(1, account.id);
                preparedStatement.setDouble(2, account.balance);
                preparedStatement.setString(3, account.currency);
                preparedStatement.setString(4, client.id);

                preparedStatement.executeUpdate();
            }
        }
    }


    private static void insertBankCards(Connection connection, Client client) throws SQLException {
        String insertBankCardQuery = "INSERT INTO bankcard (id, card_number, card_holder_name, " +
                "cvv, expiration_date, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        List<BankCard> bankCards = client.bankCards;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBankCardQuery)) {
            for (BankCard bankCard : bankCards) {
                preparedStatement.setString(1, bankCard.id);
                preparedStatement.setString(2, bankCard.cardNumber);
                preparedStatement.setString(3, bankCard.cardHolderName);
                preparedStatement.setString(4, bankCard.expirationDate);
                preparedStatement.setString(5, bankCard.cvv);
                preparedStatement.setString(6, client.id);

                preparedStatement.executeUpdate();
            }
        }
    }


    private static void insertCredits(Connection connection, Client client) throws SQLException {
        String insertCreditQuery = "INSERT INTO credit (id, start_date, end_date, " +
                "amount, interest_rate, currency, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        List<Credit> credits = client.credits;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCreditQuery)) {
            for (Credit credit : credits) {
                preparedStatement.setString(1, credit.id);
                preparedStatement.setString(2, credit.startDate);
                preparedStatement.setString(3, credit.endDate);
                preparedStatement.setDouble(4, credit.amount);
                preparedStatement.setDouble(5, credit.interestRate);
                preparedStatement.setString(6, credit.currency);
                preparedStatement.setString(7, client.id);

                preparedStatement.executeUpdate();
            }
        }
    }

    private static void insertDeposits(Connection connection, Client client) throws SQLException {
        String insertDepositQuery = "INSERT INTO deposit (id, start_date, end_date, " +
                "amount, interest_rate, currency, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        List<Deposit> deposits = client.deposits;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDepositQuery)) {
            for (Deposit deposit : deposits) {
                preparedStatement.setString(1, deposit.id);
                preparedStatement.setString(2, deposit.startDate);
                preparedStatement.setString(3, deposit.endDate);
                preparedStatement.setDouble(4, deposit.amount);
                preparedStatement.setDouble(5, deposit.interestRate);
                preparedStatement.setString(6, deposit.currency);
                preparedStatement.setString(7, client.id);

                preparedStatement.executeUpdate();
            }
        }
    }

    private static void insertTransactionHistories(Connection connection, Client client) throws SQLException {
        String insertTransactionHistoryQuery = "INSERT INTO transactionhistory (id, totalTransactions, totalDeposits, " +
                "totalWithdrawals, totalTransfers, client_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        TransactionHistory transactionHistories = client.transactionHistory;


        try (PreparedStatement preparedStatement = connection.prepareStatement(insertTransactionHistoryQuery)) {
            preparedStatement.setString(1, transactionHistories.id);
            preparedStatement.setDouble(2, transactionHistories.totalTransactions);
            preparedStatement.setDouble(3, transactionHistories.totalDeposits);
            preparedStatement.setDouble(4, transactionHistories.totalWithdrawals);
            preparedStatement.setDouble(5, transactionHistories.totalTransfers);
            preparedStatement.setString(6, client.id);


            preparedStatement.executeUpdate();
        }
    }



}
