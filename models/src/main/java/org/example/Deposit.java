package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deposit {
    public final String id;
    public final String startDate;
    public final String endDate;
    public final Double amount;
    public final Double interestRate;
    public final String currency;

    @JsonCreator
    public Deposit(@JsonProperty("id") String id,
                   @JsonProperty("startDate") String startDate,
                   @JsonProperty("endDate") String endDate,
                   @JsonProperty("amount") Double amount,
                   @JsonProperty("interestRate") Double interestRate,
                   @JsonProperty("currency") String currency) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.interestRate = interestRate;
        this.currency = currency;
    }

    public Deposit withId(String newId) {
        return new Deposit(newId, startDate, endDate, amount, interestRate, currency);
    }

    public Deposit withStartDate(String newStartDate) {
        return new Deposit(id, newStartDate, endDate, amount, interestRate, currency);
    }

    public Deposit withEndDate(String newEndDate) {
        return new Deposit(id, startDate, newEndDate, amount, interestRate, currency);
    }

    public Deposit withAmount(Double newAmount) {
        return new Deposit(id, startDate, endDate, newAmount, interestRate, currency);
    }

    public Deposit withInterestRate(Double newInterestRate) {
        return new Deposit(id, startDate, endDate, amount, newInterestRate, currency);
    }

    public Deposit withCurrency(String newCurrency) {
        return new Deposit(id, startDate, endDate, amount, interestRate, newCurrency);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
