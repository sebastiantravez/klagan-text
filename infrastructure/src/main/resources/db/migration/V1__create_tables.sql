CREATE TABLE product (
	product_id numeric NOT NULL,
	code varchar(150) NOT NULL,
	name varchar(150) NOT NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_id)
);

CREATE TABLE brand (
    brand_id numeric NOT NULL,
    name varchar(150) NOT NULL,
    CONSTRAINT brand_pkey PRIMARY KEY (brand_id)
);

CREATE TABLE price_list (
	price_list_id numeric NOT NULL,
	start_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	end_date TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
	price numeric(6,2) NOT NULL,
	priority numeric NOT NULL,
	curr varchar(5) NULL,
	product_id numeric NOT NULL,
	brand_id numeric NOT NULL,
	CONSTRAINT price_list_id PRIMARY KEY (price_list_id),
	CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product(product_id),
	CONSTRAINT fk_brand_id FOREIGN KEY (brand_id) REFERENCES brand(brand_id)
);

-- Insert register on products table
INSERT INTO product (product_id, code, name) VALUES (10, 'B23412', 'Producto A');
INSERT INTO product (product_id, code, name) VALUES (12, 'XYZ789', 'Producto B');
INSERT INTO product (product_id, code, name) VALUES (13, 'DEF456', 'Producto C');
INSERT INTO product (product_id, code, name) VALUES (14, 'GHI789', 'Producto D');
INSERT INTO product (product_id, code, name) VALUES (15, 'JKL012', 'Producto E');
INSERT INTO product (product_id, code, name) VALUES (35455, 'TESTL012', 'XYZ-TEST');

-- Insert register on brand table
INSERT INTO brand (brand_id, name) VALUES (1, 'XYZ');
INSERT INTO brand (brand_id, name) VALUES (2, 'ZARA');
INSERT INTO brand (brand_id, name) VALUES (3, 'PULL&BEAR');

-- Insert register on price_list table
INSERT INTO price_list (price_list_id, start_date, end_date, price, priority, curr, product_id, brand_id)
VALUES

    (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.50, 0, 'EUR', 35455, 1),
    (2, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 1, 'EUR', 35455, 1),
    (3, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.50, 1, 'EUR', 35455, 1),
    (4, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 38.95, 1, 'EUR', 35455, 1),

    (11, TO_CHAR(CURRENT_TIMESTAMP - 1, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 1, 'YYYY-MM-DD HH24:MI:SS'), 100.00, 1, 'EUR', 10, 1),
    (12, TO_CHAR(CURRENT_TIMESTAMP - 2, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 2, 'YYYY-MM-DD HH24:MI:SS'), 120.50, 0, 'EUR', 10, 1),
    (13, TO_CHAR(CURRENT_TIMESTAMP - 3, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 3, 'YYYY-MM-DD HH24:MI:SS'), 20.50, 0, 'EUR', 10, 1),
    (14, TO_CHAR(CURRENT_TIMESTAMP - 1, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 1, 'YYYY-MM-DD HH24:MI:SS'), 75.25, 0, 'EUR', 10, 2),
    (15, TO_CHAR(CURRENT_TIMESTAMP - 2, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 2, 'YYYY-MM-DD HH24:MI:SS'), 90.80, 1, 'EUR', 10, 2),
    (16, TO_CHAR(CURRENT_TIMESTAMP - 1, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 1, 'YYYY-MM-DD HH24:MI:SS'), 110.75, 1, 'EUR', 10, 3),
    (17, TO_CHAR(CURRENT_TIMESTAMP - 2, 'YYYY-MM-DD HH24:MI:SS'), TO_CHAR(CURRENT_TIMESTAMP + 2, 'YYYY-MM-DD HH24:MI:SS'), 10.75, 1, 'EUR', 10, 3);









