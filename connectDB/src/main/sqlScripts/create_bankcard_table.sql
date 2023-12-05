CREATE TABLE IF NOT EXISTS bankcard (
    id VARCHAR(36) PRIMARY KEY,
    card_number VARCHAR(50) NOT NULL,
    card_holder_name VARCHAR(255) NOT NULL,
    expiration_date VARCHAR(40) NOT NULL,
    cvv VARCHAR(40) NOT NULL,
    client_id VARCHAR(36),
    FOREIGN KEY (client_id) REFERENCES client (id) ON DELETE CASCADE
);