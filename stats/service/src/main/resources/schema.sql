CREATE TABLE IF NOT EXISTS hits (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    app VARCHAR(512) NOT NULL,
    uri VARCHAR(100) NOT NULL,
    ip VARCHAR(100) NOT NULL,
    timestamp timestamp NOT NULL,
    CONSTRAINT pk_hits PRIMARY KEY (id)
);