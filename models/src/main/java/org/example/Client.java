package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Client {
    public final String id;
    public final String firstName;
    public final String lastName;
    public final String dateOfBirth;
    public final String address;
    public final String phoneNumber;
    public final String emailAddress;
    public final List<Account> accounts;
    public final List<BankCard> bankCards;
    public final List<Deposit> deposits;
    public final List<Credit> credits;
    public final TransactionHistory transactionHistory;


    @JsonCreator
    public Client(@JsonProperty("id") String id,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("dateOfBirth") String dateOfBirth,
                  @JsonProperty("address") String address,
                  @JsonProperty("phoneNumber") String phoneNumber,
                  @JsonProperty("emailAddress") String emailAddress,
                  @JsonProperty("accounts") List<Account> accounts,
                  @JsonProperty("bankCards") List<BankCard> bankCards,
                  @JsonProperty("deposits") List<Deposit> deposits,
                  @JsonProperty("credits") List<Credit> credits,
                  @JsonProperty("transactionHistory") TransactionHistory transactionHistory) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.accounts = accounts;
        this.bankCards = bankCards;
        this.deposits = deposits;
        this.credits = credits;
        this.transactionHistory = transactionHistory;
    }


    public Client(String id, String firstName, String lastName, String dateOfBirth, String address, String phoneNumber, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.accounts = null;
        this.bankCards = null;
        this.credits = null;
        this.deposits = null;
        this.transactionHistory = null;
    }



    // Добавляем методы для обновления атрибутов

    public Client withId(String newId) {
        return new Client(newId, this.firstName, this.lastName, this.dateOfBirth, this.address, this.phoneNumber, this.emailAddress,
                this.accounts, this.bankCards, this.deposits, this.credits, this.transactionHistory);
    }

    public Client withFirstName(String newFirstName) {
        return new Client(id, newFirstName, lastName, dateOfBirth, address,
                phoneNumber, emailAddress, accounts, bankCards, deposits,
                credits, transactionHistory);
    }

    // Добавляем методы для обновления других атрибутов (аналогично)
    public Client withLastName(String newLastName) {
        return new Client(id, firstName, newLastName, dateOfBirth, address,
                phoneNumber, emailAddress, accounts, bankCards, deposits,
                credits, transactionHistory);
    }

    public Client withDateOfBirth(String newDateOfBirth) {
        return new Client(id, firstName, lastName, newDateOfBirth, address,
                phoneNumber, emailAddress, accounts, bankCards, deposits,
                credits, transactionHistory);
    }

    public Client withAddress(String newAddress) {
        return new Client(id, firstName, lastName, dateOfBirth, newAddress,
                phoneNumber, emailAddress, accounts, bankCards, deposits,
                credits, transactionHistory);
    }

    public Client withPhoneNumber(String newPhoneNumber) {
        return new Client(id, firstName, lastName, dateOfBirth, address,
                newPhoneNumber, emailAddress, accounts, bankCards, deposits,
                credits, transactionHistory);
    }

    public Client withEmailAddress(String newEmailAddress) {
        return new Client(id, firstName, lastName, dateOfBirth, address,
                phoneNumber, newEmailAddress, accounts, bankCards, deposits,
                credits, transactionHistory);
    }

    public Client withBankAccount(List<Account> newAccounts) {
        return new Client(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                newAccounts, bankCards, deposits, credits, transactionHistory);
    }

    public Client withBankCard(List<BankCard> newBankCard) {
        return new Client(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                accounts, newBankCard, deposits, credits, transactionHistory);
    }

    public Client withDeposit(List<Deposit> newDeposit) {
        return new Client(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                accounts, bankCards, newDeposit, credits, transactionHistory);
    }

    public Client withCredit(List<Credit> newCredit) {
        return new Client(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                accounts, bankCards, deposits, newCredit, transactionHistory);
    }

    public Client withTransactionHistory(TransactionHistory newTransactionHistory) {
        return new Client(id, firstName, lastName, dateOfBirth, address, phoneNumber, emailAddress,
                accounts, bankCards, deposits, credits, newTransactionHistory);
    }


    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", account=" + accounts +
                ", bankCard=" + bankCards +
                ", deposit=" + deposits +
                ", credit=" + credits +
                ", transactionHistory=" + transactionHistory +
                '}';
    }
}






