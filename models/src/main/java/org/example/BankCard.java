package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BankCard {

    public final String id;
    public final String cardNumber;
    public final String cardHolderName;
    public final String expirationDate;
    public final String cvv;

    @JsonCreator
    public BankCard(
            @JsonProperty("id") String id,
            @JsonProperty("cardNumber") String cardNumber,
            @JsonProperty("cardHolderName") String cardHolderName,
            @JsonProperty("expirationDate") String expirationDate,
            @JsonProperty("cvv") String cvv) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public BankCard withId(String newId) {
        return new BankCard(newId, cardNumber, cardHolderName, expirationDate, cvv);
    }

    public BankCard withCardNumber(String newCardNumber) {
        return new BankCard(id, newCardNumber, cardHolderName, expirationDate, cvv);
    }

    public BankCard withCardHolderName(String newCardHolderName) {
        return new BankCard(id, cardNumber, newCardHolderName, expirationDate, cvv);
    }

    public BankCard withExpirationDate(String newExpirationDate) {
        return new BankCard(id, cardNumber, cardHolderName, newExpirationDate, cvv);
    }

    public BankCard withCvv(String newCvv) {
        return new BankCard(id, cardNumber, cardHolderName, expirationDate, newCvv);
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id='" + id + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
