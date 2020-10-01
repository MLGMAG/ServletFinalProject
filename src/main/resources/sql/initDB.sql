CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA "WebMarket";

CREATE TABLE "WebMarket".status
(
    id   uuid                              NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Status_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_status_name UNIQUE (name)
);

CREATE TABLE "WebMarket"."order"
(
    id          uuid NOT NULL,
    status      uuid NOT NULL,
    adding_date date NOT NULL,
    CONSTRAINT "Order_pkey" PRIMARY KEY (id),
    CONSTRAINT status FOREIGN KEY (status)
        REFERENCES "WebMarket".status (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE "WebMarket".color
(
    id   uuid                              NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Color_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_color_name UNIQUE (name)
);

CREATE TABLE "WebMarket".product
(
    id          uuid                              NOT NULL,
    name        text COLLATE pg_catalog."default" NOT NULL,
    price       money                             NOT NULL,
    adding_date date                              NOT NULL,
    color       uuid                              NOT NULL,
    CONSTRAINT "Product_pkey" PRIMARY KEY (id),
    CONSTRAINT color_id FOREIGN KEY (color)
        REFERENCES "WebMarket".color (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE "WebMarket".order_product
(
    order_id   uuid NOT NULL,
    product_id uuid NOT NULL,
    CONSTRAINT order_id FOREIGN KEY (order_id)
        REFERENCES "WebMarket"."order" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT product_id FOREIGN KEY (product_id)
        REFERENCES "WebMarket".product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE "WebMarket".bucket
(
    id uuid NOT NULL,
    CONSTRAINT bucket_pkey PRIMARY KEY (id)
);

CREATE TABLE "WebMarket".bucket_product
(
    bucket_id  uuid NOT NULL,
    product_id uuid NOT NULL,
    CONSTRAINT bucket_id FOREIGN KEY (bucket_id)
        REFERENCES "WebMarket".bucket (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT product_id FOREIGN KEY (product_id)
        REFERENCES "WebMarket".product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE "WebMarket".role
(
    id   uuid                              NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Role_pkey" PRIMARY KEY (id),
    CONSTRAINT unique_role_name UNIQUE (name)
);

CREATE TABLE "WebMarket"."user"
(
    id         uuid                              NOT NULL,
    username   uuid                              NOT NULL,
    password   text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default" NOT NULL,
    last_name  text COLLATE pg_catalog."default" NOT NULL,
    balance    money                             NOT NULL,
    bucket     uuid                              NOT NULL,
    role       uuid                              NOT NULL,
    blocked    boolean                           NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT bucket_id FOREIGN KEY (bucket)
        REFERENCES "WebMarket".bucket (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT role_id FOREIGN KEY (bucket)
        REFERENCES "WebMarket".bucket (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

INSERT INTO "WebMarket".role (id, name)
VALUES (uuid_generate_v4(), 'admin');
INSERT INTO "WebMarket".role (id, name)
VALUES (uuid_generate_v4(), 'user');
INSERT INTO "WebMarket".role (id, name)
VALUES (uuid_generate_v4(), 'guest');

INSERT INTO "WebMarket".status (id, name)
VALUES (uuid_generate_v4(), 'registered');
INSERT INTO "WebMarket".status (id, name)
VALUES (uuid_generate_v4(), 'canceled');
INSERT INTO "WebMarket".status (id, name)
VALUES (uuid_generate_v4(), 'approved');

INSERT INTO "WebMarket".color (id, name)
VALUES (uuid_generate_v4(), 'red');
INSERT INTO "WebMarket".color (id, name)
VALUES (uuid_generate_v4(), 'blue');
INSERT INTO "WebMarket".color (id, name)
VALUES (uuid_generate_v4(), 'yellow');