CREATE TABLE IF NOT EXISTS users
(
    id    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    name  VARCHAR(100) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id),
    CONSTRAINT uq_user_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS categories
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name VARCHAR(100) UNIQUE NOT NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS events
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    annotation         VARCHAR(2000),
    category_id        BIGINT   NOT NULL,
    description        VARCHAR(7000),
    event_date         TIMESTAMP WITHOUT TIME ZONE,
    created_on         TIMESTAMP WITHOUT TIME ZONE,
    published_on       TIMESTAMP WITHOUT TIME ZONE,
    initiator_id       BIGINT   NOT NULL,
    lat                FLOAT,
    lon                FLOAT,
    paid               BOOLEAN,
    participant_limit  INTEGER,
    request_moderation BOOLEAN,
    state              VARCHAR(120),
    title              VARCHAR(120),
    CONSTRAINT pk_event PRIMARY KEY (id),
    CONSTRAINT fk_event_on_category FOREIGN KEY (category_id) REFERENCES categories (id),
    CONSTRAINT fk_event_on_user FOREIGN KEY (initiator_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS requests
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    event_id     BIGINT     NOT NULL,
    requester_id BIGINT     NOT NULL,
    created      TIMESTAMP WITHOUT TIME ZONE,
    status       VARCHAR(30),
    CONSTRAINT ev_requests UNIQUE (event_id, requester_id),
    CONSTRAINT pk_requests PRIMARY KEY (id),
    CONSTRAINT fk_request_on_event FOREIGN KEY (event_id) REFERENCES events (id),
    CONSTRAINT fk_request_on_requester_user FOREIGN KEY (requester_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS compilations
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    pinned BOOLEAN      NOT NULL,
    title  VARCHAR(300),
    CONSTRAINT pk_compilation PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS compilations_events
(
    compilation_id BIGINT NOT NULL,
    event_id       BIGINT NOT NULL,
    CONSTRAINT pk_compilations_events PRIMARY KEY (compilation_id, event_id),
    CONSTRAINT fk_compilations_events_on_compilations FOREIGN KEY (compilation_id) REFERENCES compilations (id),
    CONSTRAINT fk_compilations_events_on_event FOREIGN KEY (event_id) REFERENCES events (id)
);

CREATE TABLE IF NOT EXISTS comments
(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    comment      VARCHAR(2000),
    event_id     BIGINT     NOT NULL,
    user_id      BIGINT     NOT NULL,
    publish      TIMESTAMP WITHOUT TIME ZONE,
    state              VARCHAR(120),
    CONSTRAINT pk_comments PRIMARY KEY (id),
    CONSTRAINT fk_comments_on_events FOREIGN KEY (event_id) REFERENCES events (id),
    CONSTRAINT fk_comments_on_users FOREIGN KEY (user_id) REFERENCES users (id)
);