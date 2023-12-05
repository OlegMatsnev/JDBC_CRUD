package test;

import CRUD.Delete;
import CRUD.Read;
import CRUD.Update;
import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DatabaseCrudTest {


    @DisplayName("Create operation: client table")
    @Test
    public void testCreateClient() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания клиента
        Map<String, Object> clientAttributes = new HashMap<>();
        clientAttributes.put("clientId", uniqueId);
        clientAttributes.put("firstName", "John");
        clientAttributes.put("lastName", "Doe");
        clientAttributes.put("dateOfBirth", "1990-05-15");
        clientAttributes.put("address", "123 Main St");
        clientAttributes.put("phoneNumber", "555-1234");
        clientAttributes.put("emailAddress", "john.doe@example.com");

        // Вызываем метод создания клиента в базе данных
        CRUD.Create.createClient(connection, clientAttributes);

        // Теперь читаем созданного клиента из базы данных
        Client createdClient = Read.readClientById(connection, "123450");

        // Проверяем, что созданный клиент совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdClient);
        Assertions.assertEquals("John", createdClient.firstName);
        Assertions.assertEquals("Doe", createdClient.lastName);
        Assertions.assertEquals(LocalDate.of(1990, 5, 15), LocalDate.parse(createdClient.dateOfBirth));
        Assertions.assertEquals("123 Main St", createdClient.address);
        Assertions.assertEquals("555-1234", createdClient.phoneNumber);
        Assertions.assertEquals("john.doe@example.com", createdClient.emailAddress);
    }

    @DisplayName("Create operation: account table")
    @Test
    public void testCreateAccount() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания счета
        Map<String, Object> accountAttributes = new HashMap<>();
        accountAttributes.put("accountId", uniqueId);
        accountAttributes.put("balance", 1000.0);
        accountAttributes.put("currency", "USD");
        accountAttributes.put("clientId", "1234509");

        // Вызываем метод создания счета в базе данных
        CRUD.Create.createAccount(connection, accountAttributes);

        // Теперь читаем созданный счет из базы данных
        Account createdAccount = Read.readAccountById(connection, uniqueId);

        // Проверяем, что созданный счет совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdAccount);
        Assertions.assertEquals(1000.0, createdAccount.balance);
        Assertions.assertEquals("USD", createdAccount.currency);
    }


    @DisplayName("Create operation: deposit table")
    @Test
    public void testCreateDeposit() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания кредита
        Map<String, Object> depositAttributes = new HashMap<>();
        depositAttributes.put("depositId", uniqueId);
        depositAttributes.put("startDate", "2023-01-01");
        depositAttributes.put("endDate", "2023-12-31");
        depositAttributes.put("amount", 9600.0);
        depositAttributes.put("interestRate", 2.2);
        depositAttributes.put("currency", "USD");
        depositAttributes.put("clientId", "1234509");

        // Вызываем метод создания депозита в базе данных
        CRUD.Create.createDeposit(connection, depositAttributes);

        // Теперь читаем созданный депозит из базы данных
        Deposit createdDeposit = Read.readDepositById(connection, uniqueId);

        // Проверяем, что созданный депозит совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdDeposit);
        Assertions.assertEquals("2023-01-01", createdDeposit.startDate);
        Assertions.assertEquals("2023-12-31", createdDeposit.endDate);
        Assertions.assertEquals(9600.0, createdDeposit.amount);
        Assertions.assertEquals(2.2, createdDeposit.interestRate);
        Assertions.assertEquals("USD", createdDeposit.currency);
    }

    @DisplayName("Create operation: bank card table")
    @Test
    public void testCreateBankCard() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания банковской карты
        Map<String, Object> bankCardAttributes = new HashMap<>();
        bankCardAttributes.put("cardId", uniqueId);
        bankCardAttributes.put("cardNumber", "1234-5678-9012-3456");
        bankCardAttributes.put("cardHolderName", "Julia");
        bankCardAttributes.put("expirationDate", "2025-12-31");
        bankCardAttributes.put("cvv", "123");
        bankCardAttributes.put("clientId", "1234509");

        // Вызываем метод создания банковской карты в базе данных
        CRUD.Create.createBankCard(connection, bankCardAttributes);

        // Теперь читаем созданную банковскую карту из базы данных
        BankCard createdBankCard = Read.readBankCardById(connection, uniqueId);

        // Проверяем, что созданная банковская карта совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdBankCard);
        Assertions.assertEquals("1234-5678-9012-3456", createdBankCard.cardNumber);
        Assertions.assertEquals("Julia", createdBankCard.cardHolderName);
        Assertions.assertEquals("2025-12-31", createdBankCard.expirationDate);
        Assertions.assertEquals("123", createdBankCard.cvv);
    }

    @DisplayName("Create operation: transaction history table")
    @Test
    public void testCreateTransactionHistory() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания истории транзакций
        Map<String, Object> transactionAttributes = new HashMap<>();
        transactionAttributes.put("transactionHistoryId", uniqueId);
        transactionAttributes.put("totalTransactions", 500.0);
        transactionAttributes.put("totalDeposits", 300.0);
        transactionAttributes.put("totalWithdrawals", 150.0);
        transactionAttributes.put("totalTransfers", 50.0);
        transactionAttributes.put("client_id", "1234509");

        // Вызываем метод создания истории транзакций в базе данных
        CRUD.Create.createTransactionHistory(connection, transactionAttributes);

        // Теперь читаем созданную историю транзакций из базы данных
        TransactionHistory createdTransactionHistory = Read.readTransactionHistoryById(connection, uniqueId);

        // Проверяем, что созданная история транзакций совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdTransactionHistory);
        Assertions.assertEquals(500.0, createdTransactionHistory.totalTransactions);
        Assertions.assertEquals(300.0, createdTransactionHistory.totalDeposits);
        Assertions.assertEquals(150.0, createdTransactionHistory.totalWithdrawals);
        Assertions.assertEquals(50.0, createdTransactionHistory.totalTransfers);
    }



    @DisplayName("Create operation: credit table")
    @Test
    public void testCreateCredit() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания кредита
        Map<String, Object> creditAttributes = new HashMap<>();
        creditAttributes.put("creditId", uniqueId);
        creditAttributes.put("startDate", "2023-01-01");
        creditAttributes.put("endDate", "2023-12-31");
        creditAttributes.put("amount", 5000.0);
        creditAttributes.put("interestRate", 5.0);
        creditAttributes.put("currency", "USD");
        creditAttributes.put("clientId", "1234509");

        // Вызываем метод создания кредита в базе данных
        CRUD.Create.createCredit(connection, creditAttributes);

        // Теперь читаем созданный кредит из базы данных
        Credit createdCredit = Read.readCreditById(connection, uniqueId);

        // Проверяем, что созданный кредит совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdCredit);
        Assertions.assertEquals("2023-01-01", createdCredit.startDate);
        Assertions.assertEquals("2023-12-31", createdCredit.endDate);
        Assertions.assertEquals(5000.0, createdCredit.amount);
        Assertions.assertEquals(5.0, createdCredit.interestRate);
        Assertions.assertEquals("USD", createdCredit.currency);
    }


    @DisplayName("Update operation: client table")
    @Test
    public void testUpdateClientRecordAttribute() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания клиента
        Map<String, Object> clientAttributes = new HashMap<>();
        clientAttributes.put("clientId", uniqueId);
        clientAttributes.put("firstName", "John");
        clientAttributes.put("lastName", "Doe");
        clientAttributes.put("dateOfBirth", "1990-05-15");
        clientAttributes.put("address", "123 Main St");
        clientAttributes.put("phoneNumber", "555-1234");
        clientAttributes.put("emailAddress", "john.doe@example.com");

        // Вызываем метод создания клиента в базе данных
        CRUD.Create.createClient(connection, clientAttributes);

        // Теперь читаем созданного клиента из базы данных
        Client createdClient = Read.readClientById(connection, uniqueId);

        // Проверяем, что созданный клиент совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdClient);
        Assertions.assertEquals("John", createdClient.firstName);

        // Обновляем атрибут клиента
        String newFirstName = "Jane";
        Update.updateRecordAttribute(connection, "client", uniqueId, "first_name", newFirstName);

        // Повторно читаем клиента из базы данных
        Client updatedClient = Read.readClientById(connection, uniqueId);

        // Проверяем, что атрибут клиента был успешно обновлен
        Assertions.assertNotNull(updatedClient);
        Assertions.assertEquals(newFirstName, updatedClient.firstName);
    }


    @DisplayName("Update operation: account table")
    @Test
    public void testUpdateAccountRecordAttribute() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания счета
        Map<String, Object> accountAttributes = new HashMap<>();
        accountAttributes.put("accountId", uniqueId);
        accountAttributes.put("balance", 1000.0);
        accountAttributes.put("currency", "USD");
        accountAttributes.put("clientId", "1234509");

        // Вызываем метод создания счета в базе данных
        CRUD.Create.createAccount(connection, accountAttributes);

        // Теперь читаем созданный счет из базы данных
        Account createdAccount = Read.readAccountById(connection, uniqueId);

        // Проверяем, что созданный счет совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdAccount);
        Assertions.assertEquals(1000.0, createdAccount.balance);

        // Обновляем атрибут счета
        double newBalance = 1500.0;
        Update.updateRecordAttribute(connection, "account", uniqueId, "balance", newBalance);

        // Повторно читаем счет из базы данных
        Account updatedAccount = Read.readAccountById(connection, uniqueId);

        // Проверяем, что атрибут счета был успешно обновлен
        Assertions.assertNotNull(updatedAccount);
        Assertions.assertEquals(newBalance, updatedAccount.balance);
    }

    @DisplayName("Update operation: transaction history table")
    @Test
    public void testUpdateTransactionHistoryRecordAttribute() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания истории транзакций
        Map<String, Object> transactionAttributes = new HashMap<>();
        transactionAttributes.put("transactionHistoryId", uniqueId);
        transactionAttributes.put("totalTransactions", 500.0);
        transactionAttributes.put("totalDeposits", 300.0);
        transactionAttributes.put("totalWithdrawals", 150.0);
        transactionAttributes.put("totalTransfers", 50.0);
        transactionAttributes.put("client_id", "1234509");

        // Вызываем метод создания истории транзакций в базе данных
        CRUD.Create.createTransactionHistory(connection, transactionAttributes);

        // Теперь читаем созданную историю транзакций из базы данных
        TransactionHistory createdTransactionHistory = Read.readTransactionHistoryById(connection, uniqueId);

        // Проверяем, что созданная история транзакций совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdTransactionHistory);
        Assertions.assertEquals(500.0, createdTransactionHistory.totalTransactions);

        // Обновляем атрибут истории транзакций
        double newTotalTransactions = 600.0;
        Update.updateRecordAttribute(connection, "transactionhistory", uniqueId, "totalTransactions", newTotalTransactions);

        // Повторно читаем историю транзакций из базы данных
        TransactionHistory updatedTransactionHistory = Read.readTransactionHistoryById(connection, uniqueId);

        // Проверяем, что атрибут истории транзакций был успешно обновлен
        Assertions.assertNotNull(updatedTransactionHistory);
        Assertions.assertEquals(newTotalTransactions, updatedTransactionHistory.totalTransactions);
    }

    @DisplayName("Update operation: bank card table")
    @Test
    public void testUpdateBankCardRecordAttribute() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания банковской карты
        Map<String, Object> bankCardAttributes = new HashMap<>();
        bankCardAttributes.put("cardId", uniqueId);
        bankCardAttributes.put("cardNumber", "1234567890123456");
        bankCardAttributes.put("cardHolderName", "Jake");
        bankCardAttributes.put("expirationDate", "2025-12-31");
        bankCardAttributes.put("cvv", "123");
        bankCardAttributes.put("clientId", "1234509");

        // Вызываем метод создания банковской карты в базе данных
        CRUD.Create.createBankCard(connection, bankCardAttributes);

        // Теперь читаем созданную банковскую карту из базы данных
        BankCard createdBankCard = Read.readBankCardById(connection, uniqueId);

        // Проверяем, что созданная банковская карта совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdBankCard);
        Assertions.assertEquals("1234567890123456", createdBankCard.cardNumber);

        // Обновляем атрибут банковской карты
        String newCardHolderName = "Jane Doe";
        Update.updateRecordAttribute(connection, "bankcard", uniqueId, "card_holder_name", newCardHolderName);

        // Повторно читаем банковскую карту из базы данных
        BankCard updatedBankCard = Read.readBankCardById(connection, uniqueId);

        // Проверяем, что атрибут банковской карты был успешно обновлен
        Assertions.assertNotNull(updatedBankCard);
        Assertions.assertEquals(newCardHolderName, updatedBankCard.cardHolderName);
    }

    @DisplayName("Update operation: credit table")
    @Test
    public void testUpdateCreditRecordAttribute() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания кредита
        Map<String, Object> creditAttributes = new HashMap<>();
        creditAttributes.put("creditId", uniqueId);
        creditAttributes.put("startDate", "2023-01-01");
        creditAttributes.put("endDate", "2023-12-31");
        creditAttributes.put("amount", 10000.0);
        creditAttributes.put("interestRate", 5.0);
        creditAttributes.put("currency", "USD");
        creditAttributes.put("clientId", "1234509");

        // Вызываем метод создания кредита в базе данных
        CRUD.Create.createCredit(connection, creditAttributes);

        // Теперь читаем созданный кредит из базы данных
        Credit createdCredit = Read.readCreditById(connection, uniqueId);

        // Проверяем, что созданный кредит совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdCredit);
        Assertions.assertEquals(10000.0, createdCredit.amount);

        // Обновляем атрибут кредита
        double newAmount = 15000.0;
        Update.updateRecordAttribute(connection, "credit", uniqueId, "amount", newAmount);

        // Повторно читаем кредит из базы данных
        Credit updatedCredit = Read.readCreditById(connection, uniqueId);

        // Проверяем, что атрибут кредита был успешно обновлен
        Assertions.assertNotNull(updatedCredit);
        Assertions.assertEquals(newAmount, updatedCredit.amount);
    }


    @DisplayName("Update operation: deposit table")
    @Test
    public void testUpdateDepositRecordAttribute() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания депозита
        Map<String, Object> depositAttributes = new HashMap<>();
        depositAttributes.put("depositId", uniqueId);
        depositAttributes.put("startDate", "2023-01-01");
        depositAttributes.put("endDate", "2023-12-31");
        depositAttributes.put("amount", 10000.0);
        depositAttributes.put("interestRate", 2.0);
        depositAttributes.put("currency", "USD");
        depositAttributes.put("clientId", "1234509");

        // Вызываем метод создания депозита в базе данных
        CRUD.Create.createDeposit(connection, depositAttributes);

        // Теперь читаем созданный депозит из базы данных
        Deposit createdDeposit = Read.readDepositById(connection, uniqueId);

        // Проверяем, что созданный депозит совпадает с ожидаемыми данными
        Assertions.assertNotNull(createdDeposit);
        Assertions.assertEquals(10000.0, createdDeposit.amount);

        // Обновляем атрибут депозита
        double newAmount = 12000.0;
        Update.updateRecordAttribute(connection, "deposit", uniqueId, "amount", newAmount);

        // Повторно читаем депозит из базы данных
        Deposit updatedDeposit = Read.readDepositById(connection, uniqueId);

        // Проверяем, что атрибут депозита был успешно обновлен
        Assertions.assertNotNull(updatedDeposit);
        Assertions.assertEquals(newAmount, updatedDeposit.amount);
    }

    @DisplayName("Delete operation: client table")
    @Test
    public void testDeleteClient() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания клиента
        Map<String, Object> clientAttributes = new HashMap<>();
        clientAttributes.put("clientId", uniqueId);
        clientAttributes.put("firstName", "John");
        clientAttributes.put("lastName", "Doe");
        clientAttributes.put("dateOfBirth", "1990-05-15");
        clientAttributes.put("address", "123 Main St");
        clientAttributes.put("phoneNumber", "555-1234");
        clientAttributes.put("emailAddress", "john.doe@example.com");

        // Вызываем метод создания клиента в базе данных
        CRUD.Create.createClient(connection, clientAttributes);

        // Теперь читаем созданного клиента из базы данных
        Client createdClient = Read.readClientById(connection, uniqueId);

        // Проверяем, что созданный клиент существует
        Assertions.assertNotNull(createdClient);

        // Вызываем метод удаления клиента по идентификатору
        Delete.deleteRow(connection, "client", uniqueId);

        // Пытаемся снова прочитать клиента из базы данных
        Client deletedClient = Read.readClientById(connection, uniqueId);

        // Проверяем, что клиент был успешно удален
        Assertions.assertNull(deletedClient);
    }

    @DisplayName("Delete account: client table")
    @Test
    public void testDeleteAccount() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания счета
        Map<String, Object> accountAttributes = new HashMap<>();
        accountAttributes.put("accountId", uniqueId);
        accountAttributes.put("balance", 1000.0);
        accountAttributes.put("currency", "USD");
        accountAttributes.put("clientId", "1234509");

        // Вызываем метод создания счета в базе данных
        CRUD.Create.createAccount(connection, accountAttributes);

        // Теперь читаем созданный счет из базы данных
        Account createdAccount = Read.readAccountById(connection, uniqueId);

        // Проверяем, что созданный счет существует
        Assertions.assertNotNull(createdAccount);

        // Вызываем метод удаления счета по идентификатору
        Delete.deleteRow(connection, "account", uniqueId);

        // Пытаемся снова прочитать счет из базы данных
        Account deletedAccount = Read.readAccountById(connection, uniqueId);

        // Проверяем, что счет был успешно удален
        Assertions.assertNull(deletedAccount);
    }


    @DisplayName("Delete operation: bank card table")
    @Test
    public void testDeleteBankCard() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания банковской карты
        Map<String, Object> bankCardAttributes = new HashMap<>();
        bankCardAttributes.put("cardId", uniqueId);
        bankCardAttributes.put("cardNumber", "1234567890123456");
        bankCardAttributes.put("cardHolderName", "Jake");
        bankCardAttributes.put("expirationDate", "2025-12-31");
        bankCardAttributes.put("cvv", "123");
        bankCardAttributes.put("clientId", "1234509");

        // Вызываем метод создания банковской карты в базе данных
        CRUD.Create.createBankCard(connection, bankCardAttributes);

        // Теперь читаем созданную банковскую карту из базы данных
        BankCard createdBankCard = Read.readBankCardById(connection, uniqueId);

        // Проверяем, что созданная банковская карта существует
        Assertions.assertNotNull(createdBankCard);

        // Вызываем метод удаления банковской карты по идентификатору
        Delete.deleteRow(connection, "bankcard", uniqueId);

        // Пытаемся снова прочитать банковскую карту из базы данных
        BankCard deletedBankCard = Read.readBankCardById(connection, uniqueId);

        // Проверяем, что банковская карта была успешно удалена
        Assertions.assertNull(deletedBankCard);
    }


    @DisplayName("Delete operation: credit table")
    @Test
    public void testDeleteCredit() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания кредита
        Map<String, Object> creditAttributes = new HashMap<>();
        creditAttributes.put("creditId", uniqueId);
        creditAttributes.put("startDate", "2023-01-01");
        creditAttributes.put("endDate", "2023-12-31");
        creditAttributes.put("amount", 10000.0);
        creditAttributes.put("interestRate", 5.0);
        creditAttributes.put("currency", "USD");
        creditAttributes.put("client_id", "1234509");

        // Вызываем метод создания кредита в базе данных
        CRUD.Create.createCredit(connection, creditAttributes);

        // Теперь читаем созданный кредит из базы данных
        Credit createdCredit = Read.readCreditById(connection, uniqueId);

        // Проверяем, что созданный кредит существует
        Assertions.assertNotNull(createdCredit);

        // Вызываем метод удаления кредита по идентификатору
        Delete.deleteRow(connection, "credit", uniqueId);

        // Пытаемся снова прочитать кредит из базы данных
        Credit deletedCredit = Read.readCreditById(connection, uniqueId);

        // Проверяем, что кредит был успешно удален
        Assertions.assertNull(deletedCredit);
    }

    @DisplayName("Delete operation: deposit table")
    @Test
    public void testDeleteDeposit() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания депозита
        Map<String, Object> depositAttributes = new HashMap<>();
        depositAttributes.put("depositId", uniqueId);
        depositAttributes.put("startDate", "2023-01-01");
        depositAttributes.put("endDate", "2023-12-31");
        depositAttributes.put("amount", 10000.0);
        depositAttributes.put("interestRate", 2.0);
        depositAttributes.put("currency", "USD");
        depositAttributes.put("clientId", "1234509");

        // Вызываем метод создания кредита в базе данных
        CRUD.Create.createDeposit(connection, depositAttributes);

        // Теперь читаем созданный кредит из базы данных
        Deposit createdDeposit = Read.readDepositById(connection, uniqueId);

        // Проверяем, что созданный кредит существует
        Assertions.assertNotNull(createdDeposit);

        // Вызываем метод удаления кредита по идентификатору
        Delete.deleteRow(connection, "deposit", uniqueId);

        // Пытаемся снова прочитать кредит из базы данных
        Credit deletedDeposit = Read.readCreditById(connection, uniqueId);

        // Проверяем, что кредит был успешно удален
        Assertions.assertNull(deletedDeposit);
    }

    @DisplayName("Delete operation: transaction table")
    @Test
    public void testDeleteTransactionHistory() throws SQLException {
        Connection connection = DatabaseInitializer.getConnection();

        // Генерируем уникальный идентификатор
        String uniqueId = UUID.randomUUID().toString();

        // Подготавливаем тестовые данные для создания истории транзакций
        Map<String, Object> transactionAttributes = new HashMap<>();
        transactionAttributes.put("transactionHistoryId", uniqueId);
        transactionAttributes.put("totalTransactions", 500.0);
        transactionAttributes.put("totalDeposits", 300.0);
        transactionAttributes.put("totalWithdrawals", 150.0);
        transactionAttributes.put("totalTransfers", 50.0);
        transactionAttributes.put("client_id", "1234509");

        // Вызываем метод создания истории транзакций в базе данных
        CRUD.Create.createTransactionHistory(connection, transactionAttributes);

        // Теперь читаем созданную историю транзакций из базы данных
        TransactionHistory createdTransactionHistory = Read.readTransactionHistoryById(connection, uniqueId);

        // Проверяем, что созданная история транзакций существует
        Assertions.assertNotNull(createdTransactionHistory);

        // Вызываем метод удаления истории транзакций по идентификатору
        Delete.deleteRow(connection, "transactionhistory", uniqueId);

        // Пытаемся снова прочитать историю транзакций из базы данных
        TransactionHistory deletedTransactionHistory = Read.readTransactionHistoryById(connection, uniqueId);

        // Проверяем, что история транзакций была успешно удалена
        Assertions.assertNull(deletedTransactionHistory);
    }
}

