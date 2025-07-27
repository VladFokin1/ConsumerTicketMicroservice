DROP TABLE IF EXISTS ticket_purchase_events;

CREATE TABLE ticket_purchase_events (
    id SERIAL PRIMARY KEY,
    ticket_id INT NOT NULL,
    user_id INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    ticket_date TIMESTAMP NOT NULL,
    route_id INT NOT NULL
);