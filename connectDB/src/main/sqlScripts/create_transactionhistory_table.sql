CREATE TABLE IF NOT EXISTS transactionhistory (
    id VARCHAR(36) PRIMARY KEY,
    totalTransactions decimal CHECK (totalTransactions >= 0) default 0,
    totalDeposits decimal CHECK (totalDeposits >= 0) default 0,
    totalWithdrawals decimal CHECK (totalWithdrawals >= 0) default 0,
    totalTransfers decimal CHECK (totalTransfers >= 0) default 0,
    client_id VARCHAR(36),
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);