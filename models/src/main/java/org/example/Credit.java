package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Credit {
    public final String id;
    public final String startDate;
    public final String endDate;
    public final Double amount;
    public final Double interestRate;
    public final String currency;

    @JsonCreator
    public Credit(@JsonProperty("id") String id,
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

    public Credit withId(String newId) {
        return new Credit(newId, startDate, endDate, amount, interestRate, currency);
    }

    public Credit withStartDate(String newStartDate) {
        return new Credit(id, newStartDate, endDate, amount, interestRate, currency);
    }

    public Credit withEndDate(String newEndDate) {
        return new Credit(id, startDate, newEndDate, amount, interestRate, currency);
    }

    public Credit withAmount(Double newAmount) {
        return new Credit(id, startDate, endDate, newAmount, interestRate, currency);
    }

    public Credit withInterestRate(Double newInterestRate) {
        return new Credit(id, startDate, endDate, amount, newInterestRate, currency);
    }

    public Credit withCurrency(String newCurrency) {
        return new Credit(id, startDate, endDate, amount, interestRate, newCurrency);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id='" + id + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", currency='" + currency + '\'' +
                '}';
    }
}
