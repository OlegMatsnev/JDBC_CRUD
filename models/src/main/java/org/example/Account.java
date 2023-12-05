package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    public final String id;
    public final Double balance;
    public final String currency;

    @JsonCreator
    public Account(
            @JsonProperty("id") String id,
            @JsonProperty("balance") Double balance,
            @JsonProperty("currency") String currency) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
    }

    // Методы для создания новых объектов с обновленными значениями без использования "this"

    public Account withId(String newId) {
        return new Account(newId, balance, currency);
    }

    public Account withBalance(Double newBalance) {
        return new Account(id, newBalance, currency);
    }

    public Account withCurrency(String newCurrency) {
        return new Account(id, balance, newCurrency);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance='" + balance + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
