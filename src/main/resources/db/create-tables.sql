CREATE TYPE "music-instrument-assistant-schema".role AS ENUM
    (
        'ROLE_ADMIN', 'ROLE_MEMBER'
        );

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".instrument_class
(
    id   SERIAL NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".instrument_type
(
    id   SERIAL NOT NULL,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".user
(
    id       SERIAL              NOT NULL,
    login    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    role     "music-instrument-assistant-schema"."role" NOT NULL DEFAULT 'ROLE_MEMBER',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".country
(
    id   SERIAL NOT NULL,
    name VARCHAR(255) UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".manufacturer
(
    id         SERIAL       NOT NULL,
    country_id BIGINT       NOT NULL,
    name       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES "music-instrument-assistant-schema".country (id)
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".instrument
(
    id              SERIAL       NOT NULL,
    manufacturer_id BIGINT       NOT NULL,
    type_id         BIGINT       NOT NULL,
    class_id        BIGINT       NOT NULL,
    model           VARCHAR(255) NOT NULL,
    image           bytea,
    PRIMARY KEY (id),
    FOREIGN KEY (manufacturer_id) REFERENCES "music-instrument-assistant-schema".manufacturer (id),
    FOREIGN KEY (type_id) REFERENCES "music-instrument-assistant-schema".instrument_type (id),
    FOREIGN KEY (class_id) REFERENCES "music-instrument-assistant-schema".instrument_class (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".shop
(
    id           SERIAL       NOT NULL,
    address      VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20)  NOT NULL,
    website      VARCHAR(100) DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".product
(
    id            SERIAL         NOT NULL,
    instrument_id BIGINT         NOT NULL,
    shop_id       BIGINT         NOT NULL,
    price         DECIMAL(19, 2) NOT NULL,
    quantity      INT            NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (instrument_id) REFERENCES "music-instrument-assistant-schema".instrument (id),
    FOREIGN KEY (shop_id) REFERENCES "music-instrument-assistant-schema".shop (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".product_instrument
(
    product_id    BIGINT NOT NULL,
    instrument_id BIGINT NOT NULL,
    PRIMARY KEY (product_id, instrument_id),
    FOREIGN KEY (product_id) REFERENCES "music-instrument-assistant-schema".product (id),
    FOREIGN KEY (instrument_id) REFERENCES "music-instrument-assistant-schema".shop (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".shop_instrumentClass
(
    shop_id            BIGINT NOT NULL,
    instrumentClass_id BIGINT NOT NULL,
    PRIMARY KEY (shop_id, instrumentClass_id),
    FOREIGN KEY (shop_id) REFERENCES "music-instrument-assistant-schema".product (id),
    FOREIGN KEY (instrumentClass_id) REFERENCES "music-instrument-assistant-schema".shop (id)
);

CREATE TABLE IF NOT EXISTS "music-instrument-assistant-schema".shop_instrumentType
(
    shop_id           BIGINT NOT NULL,
    instrumentType_id BIGINT NOT NULL,
    PRIMARY KEY (shop_id, instrumentType_id),
    FOREIGN KEY (shop_id) REFERENCES "music-instrument-assistant-schema".product (id),
    FOREIGN KEY (instrumentType_id) REFERENCES "music-instrument-assistant-schema".shop (id)
)

