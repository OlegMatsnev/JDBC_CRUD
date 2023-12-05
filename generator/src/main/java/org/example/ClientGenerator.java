package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ClientGenerator {

    private static int lastGeneratedIndex = 1; // Статическая переменная для отслеживания последнего использованного индекса
    private static final Random random = new Random();
    public Client generateClients() {

        String id = generateUniqueId();
        String firstName = generateFirstName(lastGeneratedIndex);
        String lastName = generateLastName(lastGeneratedIndex);
        String dateOfBirth = generateDateOfBirth(lastGeneratedIndex);
        String address = generateAddress(lastGeneratedIndex);
        String phoneNumber = generatePhoneNumber(lastGeneratedIndex);
        String emailAddress = generateEmailAddress(lastGeneratedIndex);
        List<Account> accounts = generateAccount(lastGeneratedIndex);
        List<BankCard> bankCards = generateBankCard(lastGeneratedIndex);
        List<Deposit> deposits = generateDeposit(lastGeneratedIndex);
        List<Credit> credits = generateCredit(lastGeneratedIndex);
        TransactionHistory transactionHistory = generateTransactionHistory(lastGeneratedIndex);

        Client client = new Client(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                accounts, bankCards, deposits, credits, transactionHistory);

        lastGeneratedIndex += 1; // Обновляем последний использованный индекс

        return client;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // Далее определите методы для генерации каждого атрибута на основе номера итерации, например:


    private String generateFirstName(int iteration) {
        return "UserName" + iteration;
    }

    private String generateLastName(int iteration) {
        return "UserLastName" + iteration;
    }

    private String generateDateOfBirth(int iteration) {
        return "UserBirthDate" + iteration;
    }

    private String generateAddress(int iteration) {
        return "UserAddress" + iteration;
    }

    private String generatePhoneNumber(int iteration) {
        return "UserPhone" + iteration;
    }

    private String generateEmailAddress(int iteration) {
        return "UserMail" + iteration;
    }




    private String generateAttributeValue(String attributeName, int iteration, int count) {
        return "User" + iteration + attributeName + count;
    }

    public List<Account> generateAccount(int index) {

        int numberOfCardsOrAccounts = generateCardOrAccountCount();

        List<Account> accounts = new ArrayList<>();


        for (int i = 1; i <= numberOfCardsOrAccounts; i++) {
            String id = generateUniqueId();
            double balance = 0.0; // Устанавливайте начальный баланс по вашему желанию
            String currency = generateAttributeValue("Currency", index, i); // Генерируем уникальное значение валюты
            accounts.add(new Account(id, balance, currency));
        }

        return accounts;

    }

    private List<BankCard> generateBankCard(int iteration) {

        int numberOfCardsOrAccounts = generateCardOrAccountCount();

        List<BankCard> bankCards = new ArrayList<>();

        for (int i = 1; i <= numberOfCardsOrAccounts; i++) {
            String id = generateUniqueId();
            String cardNumber = generateAttributeValue("CardNumber", iteration, i);
            String cardHolderName = generateAttributeValue("CardHolderName", iteration, i);
            String expirationDate = generateAttributeValue("ExpirationDate", iteration, i);
            String cvv = generateAttributeValue("CVV", iteration, i);
            bankCards.add(new BankCard(id, cardNumber, cardHolderName, expirationDate, cvv));
        }

        return bankCards;
    }

    private List<Deposit> generateDeposit(int iteration) {

        int numberOfDeposits = generateDepositCount();
        List<Deposit> deposits = new ArrayList<>();


        for (int i = 0; i < numberOfDeposits; i++) {
            String id = generateUniqueId();
            String startDate = generateAttributeValue("StartDate", iteration, i);
            String endDate = generateAttributeValue("EndDate", iteration, i);
            Double amount = 0.0;
            Double interestRate = 0.0;
            String currency = generateAttributeValue("Currency", iteration, i);
            deposits.add(new Deposit(id, startDate, endDate, amount, interestRate, currency));
        }

        return deposits;
    }

    private List<Credit> generateCredit(int iteration) {

        int numberOfCredits = generateDepositCount();
        List<Credit> credits = new ArrayList<>();

        for (int i = 0; i < numberOfCredits; i++) {
            String id = generateUniqueId();
            String startDate = generateAttributeValue("StartDate", iteration, i);
            String endDate = generateAttributeValue("EndDate", iteration, i);
            Double amount = 0.0;
            Double interestRate = 0.0;
            String currency = generateAttributeValue("Currency", iteration, i);
            credits.add(new Credit(id, startDate, endDate, amount, interestRate, currency));
        }

        return credits;
    }

    private TransactionHistory generateTransactionHistory(int iteration) {
        String id = generateUniqueId();
        Double totalTransactions = 0.0;
        Double totalDeposits = 0.0;
        Double totalWithdrawals = 0.0;
        Double totalTransfers = 0.0;

        return new TransactionHistory(id, totalTransactions, totalDeposits, totalWithdrawals, totalTransfers);
    }

    public static int generateCardOrAccountCount() {
        int randomNumber = generateRandomNumber();
        if (randomNumber <= 6) {
            return 1; // 60% шанс на 1 карту или счет
        } else if (randomNumber <= 9) {
            return 2; // 30% шанс на 2 карты или счета
        } else {
            return 3; // 10% шанс на 3 карты или счета
        }
    }

    private static int generateRandomNumber() {
        return random.nextInt(10 - 1 + 1) + 1;
    }

    // Генерирует количество вкладов или депозитов в соответствии с вашими условиями
    public static int generateDepositCount() {
        int randomNumber = generateRandomNumber();
        if (randomNumber <= 6) {
            return 0; // 60% шанс на 0 вкладов/депозитов
        } else if (randomNumber <= 9) {
            return 1; // 30% шанс на 1 вклад/депозит
        } else {
            return 2; // 10% шанс на 2 вклада/депозита
        }
    }


}

