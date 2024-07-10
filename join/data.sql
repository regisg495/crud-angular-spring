DROP DATABASE IF EXISTS api_product_category;

CREATE DATABASE IF NOT EXISTS api_product_category CHARACTER SET UTF8;

USE api_product_category;

DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS category
(
  id_category               SMALLINT AUTO_INCREMENT NOT NULL,
  date_update_category 		DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  name_category             VARCHAR(200)            NOT NULL UNIQUE,
  details_category         	TEXT     DEFAULT NULL,
  CONSTRAINT categoryPK PRIMARY KEY (id_category)
);


