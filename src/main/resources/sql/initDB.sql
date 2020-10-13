-- Postgres Database

CREATE SCHEMA "WebMarket";

CREATE TABLE web_market."order"
(
    id uuid NOT NULL,
    adding_date date NOT NULL,
    status text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Order_pkey" PRIMARY KEY (id)
);

CREATE TABLE web_market.product
(
    id uuid NOT NULL,
    name text COLLATE pg_catalog."default" NOT NULL,
    price money NOT NULL,
    adding_date date NOT NULL,
    color text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Product_pkey" PRIMARY KEY (id)
);

CREATE TABLE web_market.order_product
(
    order_id uuid NOT NULL,
    product_id uuid NOT NULL,
    CONSTRAINT order_id FOREIGN KEY (order_id)
        REFERENCES web_market."order" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT product_id FOREIGN KEY (product_id)
        REFERENCES web_market.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE web_market."user"
(
    id uuid NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    first_name text COLLATE pg_catalog."default" NOT NULL,
    last_name text COLLATE pg_catalog."default" NOT NULL,
    balance money NOT NULL,
    blocked boolean NOT NULL,
    username text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE web_market.user_role
(
    user_id uuid NOT NULL,
    role text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES web_market."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE web_market.user_product
(
    user_id uuid NOT NULL,
    product_id uuid NOT NULL,
    CONSTRAINT product_id FOREIGN KEY (product_id)
        REFERENCES web_market.product (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT user_id FOREIGN KEY (user_id)
        REFERENCES web_market."user" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);