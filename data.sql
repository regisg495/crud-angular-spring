DROP DATABASE IF EXISTS api_product_category;

CREATE DATABASE IF NOT EXISTS api_product_category CHARACTER SET UTF8;

USE api_product_category;

DROP TABLE IF EXISTS category;

CREATE TABLE IF NOT EXISTS category
(
  id_category               BIGINT AUTO_INCREMENT NOT NULL,
  date_update_category 		DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  name_category             VARCHAR(200) NOT NULL UNIQUE,
  details_category         	TEXT     DEFAULT NULL,
  CONSTRAINT categoryPK PRIMARY KEY (id_category)
);

DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product
(
  id_product               BIGINT AUTO_INCREMENT NOT NULL,
  date_update_product	   DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  name_product             VARCHAR(200)          NOT NULL UNIQUE,
  details_product          TEXT     DEFAULT NULL,
  price_product            DECIMAL(11, 2)        NOT NULL,
  id_category              BIGINT              NOT NULL,
  CONSTRAINT productPK PRIMARY KEY (id_product),
  CONSTRAINT product_categoryFK FOREIGN KEY (id_category) REFERENCES Category (id_category)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

INSERT INTO category(name_category, details_category) VALUES
('Informática', 'Todos os produtos relacionados a informática');

INSERT INTO category(name_category, details_category) VALUES
('Cama, Mesa e Banho', 'Roupa de cama, edredom, toalha e muito mais, com os Menores Preços do Brasil');

INSERT INTO category(name_category, details_category) VALUES
('Eletrodomésticos', 'Renove sua casa com geladeiras, fogões, lavadoras de roupa, fornos elétricos, micro-ondas, liquidificadores, aspiradores de pó, ferros de passar roupa, ar condicionado, freezers, lavadoras de louça e muitos outros itens indispensáveis');

INSERT INTO category(name_category, details_category) VALUES
('Smartphones e Celulares', 'Confira nossas ofertas de acessórios para smartphones. Opções de capas em diversas cores e películas protetoras para smartphones');

INSERT INTO category(name_category, details_category) VALUES
('TV e Vídeo', 'Encontre nas nossas Lojas uma ampla seleção de eletrônicos de qualidade em TV, Áudio e Vídeo Nossos produtos oferecem tecnologia avançada e desempenho excepcional para você desfrutar de imagens nítidas, som imersivo e entretenimento de alta qualidade.');

INSERT INTO product(name_product, details_product, price_product, id_category) VALUES
('Smart TV 43 Philips Ambilight Google TV Comando de Voz Dolby Vision Atmos',
'A ação salta da tela na Google TV Philips 4K. O conteúdo HDR tem ótima imagem, e a Ambilight torna filmes, programas e jogos maiores e mais imersivos. O Dolby Atmos proporciona um som de alta qualidade para combinar com a imagem incrível.',
 1600, 5);
 
INSERT INTO product(name_product, details_product, price_product, id_category) VALUES
('iPhone 14 Apple 128 GB, 12MP, 5G com Tela Super Retina XDR - Meia-Noite',
'O iPhone 14 Apple 128 GB, 12MP, 5G com Tela Super Retina XDR - Meia-Noite com Tela Super Retina XDR brilhante de 6,1 polegadas. Com a proteção Ceramic Shield, que é quatro vezes mais resistente a quedas. Fotos surpreendentes em pouca luz com o modo Noite em todas as câmeras',
 6300, 4);
 
INSERT INTO product(name_product, details_product, price_product, id_category) VALUES
('Smartphone Motorola Moto G54 5G, Câmera Dupla, 256 GB, Azul - XT2343',
'O Smartphone Motorola Moto G54 5G, Câmera Dupla, 256 GB, Azul - XT2343 é a opção perfeita para ser seu novo smartphone!',
 1199, 4);
 
INSERT INTO product(name_product, details_product, price_product, id_category) VALUES
('Computador Desktop, Intel Core I3 3º Geração, 8GB RAM, HD SSD 480GB, Conexões USB/VGA/HDMI/LAN/SOM',
'MARCA: COMPUTADOR DESKTOP INTEL MODELO: GABINETE PRETO ATX | INTEL CORE I3 3ª GERAÇÃO',
 773, 1);
 
 