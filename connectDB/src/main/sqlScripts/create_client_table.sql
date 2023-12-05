CREATE TABLE client (
    id VARCHAR(36) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth VARCHAR(40) NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(20),
    email_address VARCHAR(255)
);
