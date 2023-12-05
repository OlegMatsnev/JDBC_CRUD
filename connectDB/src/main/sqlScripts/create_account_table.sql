CREATE TABLE IF NOT EXISTS account (
    id VARCHAR(36) PRIMARY KEY,
    balance decimal CHECK (balance >= 0 and balance <= 1000000),
    currency VARCHAR(40) DEFAULT 'RUB',
    client_id VARCHAR(36) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);