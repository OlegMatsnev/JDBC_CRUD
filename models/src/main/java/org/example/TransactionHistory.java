package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionHistory {
    public final String id;
    public final Double totalTransactions;
    public final Double totalDeposits;
    public final Double totalWithdrawals;
    public final Double totalTransfers;

    @JsonCreator
    public TransactionHistory(
            @JsonProperty("id") String id,
            @JsonProperty("totalTransactions") Double totalTransactions,
            @JsonProperty("totalDeposits") Double totalDeposits,
            @JsonProperty("totalWithdrawals") Double totalWithdrawals,
            @JsonProperty("totalTransfers") Double totalTransfers) {
        this.id = id;
        this.totalTransactions = totalTransactions;
        this.totalDeposits = totalDeposits;
        this.totalWithdrawals = totalWithdrawals;
        this.totalTransfers = totalTransfers;
    }

    public TransactionHistory withId(String newId) {
        return new TransactionHistory(newId, totalTransactions, totalDeposits, totalWithdrawals, totalTransfers);
    }

    public TransactionHistory withTotalTransactions(Double newTotalTransactions) {
        return new TransactionHistory(id, newTotalTransactions, totalDeposits, totalWithdrawals, totalTransfers);
    }

    public TransactionHistory withTotalDeposits(Double newTotalDeposits) {
        return new TransactionHistory(id, totalTransactions, newTotalDeposits, totalWithdrawals, totalTransfers);
    }

    public TransactionHistory withTotalWithdrawals(Double newTotalWithdrawals) {
        return new TransactionHistory(id, totalTransactions, totalDeposits, newTotalWithdrawals, totalTransfers);
    }

    public TransactionHistory withTotalTransfers(Double newTotalTransfers) {
        return new TransactionHistory(id, totalTransactions, totalDeposits, totalWithdrawals, newTotalTransfers);
    }


    @Override
    public String toString() {
        return "TransactionHistory{" +
                "id='" + id + '\'' +
                ", totalTransactions=" + totalTransactions +
                ", totalDeposits=" + totalDeposits +
                ", totalWithdrawals=" + totalWithdrawals +
                ", totalTransfers=" + totalTransfers +
                '}';
    }
}
