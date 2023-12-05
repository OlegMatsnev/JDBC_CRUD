package org.example;

import CRUD.Create;
import CRUD.Delete;
import CRUD.Read;
import CRUD.Update;
import console_utils.General;

import java.sql.*;
import java.util.*;

import static console_utils.CreateUtils.*;
import static console_utils.General.*;
import static console_utils.UpdateUtils.collectUpdateData;
import static CRUD.Create.*;
import static CRUD.Read.*;
import static org.example.Operation.*;

public class AppCRUD {

    public void start() {

        try {
            // Подключение к базе данных
            Connection connection = DatabaseInitializer.getConnection();

            // Бесконечный цикл для обработки операций
            while (true) {
                // Вывод меню
                General.displayMenu();
                // Запрос у пользователя выбора операции
                int operationChoice = General.getUserInputAsInt("Enter operation number:");
                // Выбор операции и передача управления соответствующему классу
                Operation operation = Operation.values()[operationChoice];
                switch (operation) {
                    case CREATE:

                        int tableChoice = General.getTableNum(scanner);
                        Table table = Table.values()[tableChoice - 1];
                        switch (table) {
                            case CLIENT:
                                Map<String, Object> clientAttributes = collectClientData(scanner);
                                createClient(connection, clientAttributes);
                                break;
                            case ACCOUNT:
                                Map<String, Object> accountAttributes = collectAccountData(scanner);
                                createAccount(connection, accountAttributes);
                                break;
                            case CREDIT:
                                Map<String, Object> creditAttributes = collectCreditData(scanner);
                                createCredit(connection, creditAttributes);
                                break;
                            case DEPOSIT:
                                Map<String, Object> depositAttributes = collectDepositData(scanner);
                                createDeposit(connection, depositAttributes);
                                break;
                            case BANK_CARD:
                                Map<String, Object> bankCardAttributes = collectBankCardData(scanner);
                                createBankCard(connection, bankCardAttributes);
                                break;
                            case TRANSACTION_HISTORY:
                                Map<String, Object> transactionAttributes = collectTransactionHistoryData(scanner);
                                createTransactionHistory(connection, transactionAttributes);
                                break;
                            default:
                                System.out.println("Invalid table number.");
                        }
                        break;

                    case READ:

                        int choice = getUserInputAsInt("Enter 1 to read a specific tuple, 2 to read the entire table:");
                        int tableChoice2 = General.getTableNum(scanner);
                        String tableName2 = getTableNameByChoice(tableChoice2);
                        switch (choice) {
                            case 1:


                                Table table2 = Table.values()[tableChoice2 - 1];

                                switch (table2) {
                                    case CLIENT:
                                        String clientId = getUserInput("Enter the ID of the client:");
                                        Client client = Read.readClientById(connection, clientId);
                                        System.out.println(client);
                                        break;

                                    case ACCOUNT:
                                        String accountId = getUserInput("Enter the ID of the account:");
                                        Account account = Read.readAccountById(connection, accountId);
                                        System.out.println(account);
                                        break;

                                    case CREDIT:
                                        String creditId = getUserInput("Enter the ID of the credit:");
                                        Credit credit = Read.readCreditById(connection, creditId);
                                        System.out.println(credit);
                                        break;

                                    case DEPOSIT:
                                        String depositId = getUserInput("Enter the ID of the deposit:");
                                        Deposit deposit = Read.readDepositById(connection, depositId);
                                        System.out.println(deposit);
                                        break;

                                    case BANK_CARD:
                                        String cardId = getUserInput("Enter the ID of the bank card:");
                                        BankCard bankCard = Read.readBankCardById(connection, cardId);
                                        System.out.println(bankCard);
                                        break;

                                    case TRANSACTION_HISTORY:
                                        String transactionHistoryId = getUserInput("Enter the ID of the transaction history:");
                                        TransactionHistory transactionHistory = Read.readTransactionHistoryById(connection, transactionHistoryId);
                                        System.out.println(transactionHistory);
                                        break;

                                    default:
                                        System.out.println("Invalid table selection.");
                                        break;
                                }

                                break;
                            case 2:
                                // Read the entire table
                                int limit = getUserInputAsInt("Enter the number of tuples to read (enter 0 to read all):");
                                readTable(connection, tableName2, limit);
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                        break;


                    case UPDATE:
                        int tableChoice3 = getTableNum(scanner);
                        String tableName3 = getTableNameByChoice(tableChoice3);
                        Map<String, Object> updateData = collectUpdateData(connection, scanner, tableName3);
                        if (updateData == null) {
                            break;
                        }
                        String UpdateTableName = (String) updateData.get("tableName");
                        String recordId = (String) updateData.get("recordId");
                        String attributeName = (String) updateData.get("attributeName");
                        String newValue = (String) updateData.get("newValue");

                        Update.updateRecordAttribute(connection, UpdateTableName, recordId, attributeName, newValue);
                        break;

                    case DELETE:

                        // Получаем id записи, которую будем удалять
                        tablesMenu();
                        int choiceForDelete = getUserInputAsInt("Enter the number of the table to delete the row (enter 0 to exit):");
                        String tableNameForDeleteRow = getTableNameByChoice(choiceForDelete);
                        String idOfRecord = getUserInput("Enter the ID of the record to delete");
                        Delete.deleteRow(connection, tableNameForDeleteRow, idOfRecord);
                        break;
                    case STOP:
                        System.out.println("Exiting the application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid operation number. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }




    public static void main(String[] args) {
        new AppCRUD().start();
    }
}

