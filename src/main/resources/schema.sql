DROP TABLE IF EXISTS event;

CREATE TABLE event (
    id IDENTITY,
    name VARCHAR,
    published BOOLEAN, 
    created_at timestamp
);