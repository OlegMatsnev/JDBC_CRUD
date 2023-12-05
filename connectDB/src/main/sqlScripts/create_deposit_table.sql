CREATE TABLE IF NOT EXISTS deposit (
    id VARCHAR(36) PRIMARY KEY,
    start_date VARCHAR(255) NOT NULL,
    end_date VARCHAR(255) NOT NULL,
    amount decimal CHECK (amount >= 0),
    interest_rate decimal CHECK (interest_rate >= 0 and interest_rate <= 4) NOT NULL,
    currency VARCHAR(40) default 'RUB',
    client_id VARCHAR(36),
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);