CREATE TABLE alunos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    curso VARCHAR(255),
    orientador_id BIGINT,
    empresa_id BIGINT,
    estagio_id BIGINT,
    FOREIGN KEY (orientador_id) REFERENCES orientadores(id),
    FOREIGN KEY (empresa_id) REFERENCES empresas(id),
    FOREIGN KEY (estagio_id) REFERENCES estagios(id)
);