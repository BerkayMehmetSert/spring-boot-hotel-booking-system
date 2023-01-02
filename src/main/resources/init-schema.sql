CREATE TABLE bill
(
    id         VARCHAR(255)     NOT NULL,
    price      DOUBLE PRECISION NOT NULL,
    created_at date,
    updated_at date,
    rent_id    VARCHAR(255),
    CONSTRAINT "pk_bıll" PRIMARY KEY (id)
);

CREATE TABLE bill_payment
(
    id              VARCHAR(255) NOT NULL,
    created_at      date,
    updated_at      date,
    payment_type_id VARCHAR(255),
    booking_date_id VARCHAR(255),
    CONSTRAINT "pk_bıllpayment" PRIMARY KEY (id)
);

CREATE TABLE booking
(
    id              VARCHAR(255) NOT NULL,
    created_at      date,
    updated_at      date,
    customer_id     VARCHAR(255),
    booking_date_id VARCHAR(255),
    CONSTRAINT "pk_bookıng" PRIMARY KEY (id)
);

CREATE TABLE booking_date
(
    id             VARCHAR(255) NOT NULL,
    check_in_date  date,
    check_out_date date,
    created_at     date,
    updated_at     date,
    CONSTRAINT "pk_bookıngdate" PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id          VARCHAR(255) NOT NULL,
    first_name  VARCHAR(50)  NOT NULL,
    last_name   VARCHAR(50)  NOT NULL,
    national_id VARCHAR(16)  NOT NULL,
    passport_id VARCHAR(9)   NOT NULL,
    email       VARCHAR(32)  NOT NULL,
    phone       VARCHAR(16)  NOT NULL,
    address     VARCHAR(255) NOT NULL,
    city        VARCHAR(16)  NOT NULL,
    country     VARCHAR(16)  NOT NULL,
    zip_code    VARCHAR(16)  NOT NULL,
    created_at  date,
    updated_at  date,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE floor
(
    id         VARCHAR(255) NOT NULL,
    number     VARCHAR(16)  NOT NULL,
    created_at date,
    updated_at date,
    CONSTRAINT pk_floor PRIMARY KEY (id)
);

CREATE TABLE payment_type
(
    id         VARCHAR(255) NOT NULL,
    name       VARCHAR(50)  NOT NULL,
    created_at date,
    updated_at date,
    CONSTRAINT pk_paymenttype PRIMARY KEY (id)
);

CREATE TABLE rating
(
    id          VARCHAR(255) NOT NULL,
    value       INTEGER      NOT NULL,
    description VARCHAR(140) NOT NULL,
    created_at  date,
    updated_at  date,
    CONSTRAINT "pk_ratıng" PRIMARY KEY (id)
);

CREATE TABLE rent
(
    id           VARCHAR(255)     NOT NULL,
    price        DOUBLE PRECISION NOT NULL,
    created_at   date,
    updated_at   date,
    room_type_id VARCHAR(255),
    CONSTRAINT pk_rent PRIMARY KEY (id)
);

CREATE TABLE room
(
    id           VARCHAR(255) NOT NULL,
    room_number  VARCHAR(255) NOT NULL,
    is_smoking   BOOLEAN      NOT NULL,
    created_at   date,
    updated_at   date,
    customer_id  VARCHAR(255),
    room_type_id VARCHAR(255),
    room_status  VARCHAR(255) NOT NULL,
    booking_id   VARCHAR(255),
    floor_id     VARCHAR(255),
    CONSTRAINT pk_room PRIMARY KEY (id)
);

CREATE TABLE room_key
(
    id        VARCHAR(255) NOT NULL,
    key_code  VARCHAR(255) NOT NULL,
    is_active BOOLEAN      NOT NULL,
    is_master BOOLEAN      NOT NULL,
    room_id   VARCHAR(255),
    CONSTRAINT pk_roomkey PRIMARY KEY (id)
);

CREATE TABLE room_rating
(
    id          VARCHAR(255) NOT NULL,
    name        VARCHAR(50)  NOT NULL,
    created_at  date,
    updated_at  date,
    room_id     VARCHAR(255),
    customer_id VARCHAR(255),
    rating_id   VARCHAR(255),
    CONSTRAINT "pk_roomratıng" PRIMARY KEY (id)
);

CREATE TABLE room_type
(
    id         VARCHAR(255) NOT NULL,
    name       VARCHAR(50)  NOT NULL,
    created_at date,
    updated_at date,
    CONSTRAINT pk_roomtype PRIMARY KEY (id)
);

ALTER TABLE customer
    ADD CONSTRAINT "uc_customer_natıonalıd" UNIQUE (national_id);

ALTER TABLE customer
    ADD CONSTRAINT "uc_customer_passportıd" UNIQUE (passport_id);

ALTER TABLE bill_payment
    ADD CONSTRAINT FK_BILLPAYMENT_ON_BOOKING_DATE_ID FOREIGN KEY (booking_date_id) REFERENCES booking_date (id);

ALTER TABLE bill_payment
    ADD CONSTRAINT FK_BILLPAYMENT_ON_PAYMENT_TYPE_ID FOREIGN KEY (payment_type_id) REFERENCES payment_type (id);

ALTER TABLE bill
    ADD CONSTRAINT FK_BILL_ON_RENT_ID FOREIGN KEY (rent_id) REFERENCES rent (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_BOOKING_DATE_ID FOREIGN KEY (booking_date_id) REFERENCES booking_date (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_CUSTOMER_ID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE rent
    ADD CONSTRAINT FK_RENT_ON_ROOM_TYPE_ID FOREIGN KEY (room_type_id) REFERENCES room_type (id);

ALTER TABLE room_key
    ADD CONSTRAINT FK_ROOMKEY_ON_ROOM_ID FOREIGN KEY (room_id) REFERENCES room (id);

ALTER TABLE room_rating
    ADD CONSTRAINT FK_ROOMRATING_ON_CUSTOMER_ID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE room_rating
    ADD CONSTRAINT FK_ROOMRATING_ON_RATING_ID FOREIGN KEY (rating_id) REFERENCES rating (id);

ALTER TABLE room_rating
    ADD CONSTRAINT FK_ROOMRATING_ON_ROOM_ID FOREIGN KEY (room_id) REFERENCES room (id);

ALTER TABLE room
    ADD CONSTRAINT FK_ROOM_ON_BOOKING_ID FOREIGN KEY (booking_id) REFERENCES booking (id);

ALTER TABLE room
    ADD CONSTRAINT FK_ROOM_ON_CUSTOMER_ID FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE room
    ADD CONSTRAINT FK_ROOM_ON_FLOOR_ID FOREIGN KEY (floor_id) REFERENCES floor (id);

ALTER TABLE room
    ADD CONSTRAINT FK_ROOM_ON_ROOM_TYPE_ID FOREIGN KEY (room_type_id) REFERENCES room_type (id);