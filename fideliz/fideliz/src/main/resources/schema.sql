CREATE TABLE IF NOT EXISTS LOJISTA (
 id_lojista BIGINT AUTO_INCREMENT PRIMARY KEY,
 nome varchar(255) not NULL,
 cnpj varchar(18),
 contato varchar(10),
 link_cardapio varchar(255),
 link_img varchar(255),
 link_logo varchar(255)
);

CREATE TABLE IF NOT EXISTS CLIENTE (
 id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
 nome varchar(255) NOT NULL,
 cpf varchar(14) not NULL,
 contato varchar(10) not NULL,
 email varchar(255) not NULL
);

CREATE TABLE IF NOT EXISTS RECOMPENSA (
 id_recompensa BIGINT AUTO_INCREMENT PRIMARY KEY,
 id_lojista BIGINT NOT NULL,
 qt_selo INT DEFAULT 0,
 descricao VARCHAR(255),
 FOREIGN KEY (id_lojista) REFERENCES LOJISTA(id_lojista)
);

-- Inserindo dados de novos lojistas
INSERT INTO LOJISTA (nome, cnpj, contato, link_cardapio, link_img, link_logo) VALUES
('Mercadinho São João', '12345678000195', '1122334455', 'http://mercadinho_sao_joao/cardapio', 'http://mercadinho_sao_joao/img', 'http://mercadinho_sao_joao/logo'),
('Padaria Pão Doce', '98765432000165', '5566778899', 'http://padaria_pao_doce/cardapio', 'http://padaria_pao_doce/img', 'http://padaria_pao_doce/logo'),
('Lanchonete Sabor & Cia', '56473829000185', '3344556677', 'http://lanchonete_sabor_cia/cardapio', 'http://lanchonete_sabor_cia/img', 'http://lanchonete_sabor_cia/logo');