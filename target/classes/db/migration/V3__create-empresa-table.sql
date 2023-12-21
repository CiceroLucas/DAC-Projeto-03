CREATE TABLE empresas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    setor VARCHAR(255),
    endereco VARCHAR(255)
);
