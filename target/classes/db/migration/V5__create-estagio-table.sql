CREATE TABLE estagios (
    id SERIAL PRIMARY KEY,
    descricao TEXT,
    empresa_id BIGINT,
    FOREIGN KEY (empresa_id) REFERENCES empresas(id)
);