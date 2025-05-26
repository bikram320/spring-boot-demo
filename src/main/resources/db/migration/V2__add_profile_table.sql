CREATE TABLE profile
(
    id             bigint PRIMARY KEY,
    bio            TEXT,
    phone_number   VARCHAR(15),
    date_of_birth  DATE,
    loyalty_points INT UNSIGNED DEFAULT 0,
    FOREIGN KEY (id) REFERENCES user(id)
);