-- Devisate Construções — Script de criação das tabelas
-- Fase 3: Implementação do Banco de Dados

CREATE DATABASE IF NOT EXISTS devisate_construcoes;
USE devisate_construcoes;

-- Tabela Usuário
CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    perfil VARCHAR(30) NOT NULL
);

-- Tabela Categoria
CREATE TABLE categoria (
    id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255)
);

-- Tabela Equipamento
CREATE TABLE equipamento (
    id_equipamento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(120) NOT NULL,
    descricao VARCHAR(255),
    numero_serie VARCHAR(60) UNIQUE,
    horimetro_inicial FLOAT,
    horimetro_atual FLOAT,
    status VARCHAR(30) NOT NULL DEFAULT 'DISPONIVEL',
    id_categoria INT NOT NULL,

    FOREIGN KEY (id_categoria)
        REFERENCES categoria(id_categoria)
);

-- Tabela Agendamento
CREATE TABLE agendamento (
    id_agendamento INT PRIMARY KEY AUTO_INCREMENT,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    obra_destino VARCHAR(150) NOT NULL,
    finalidade VARCHAR(255),
    status VARCHAR(30) NOT NULL DEFAULT 'PENDENTE',
    id_usuario INT NOT NULL,
    id_equipamento INT NOT NULL,

    FOREIGN KEY (id_usuario)
        REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_equipamento)
        REFERENCES equipamento(id_equipamento)
);

-- Tabela Empréstimo
CREATE TABLE emprestimo (
    id_emprestimo INT PRIMARY KEY AUTO_INCREMENT,
    data_retirada DATE NOT NULL,
    data_prevista_devolucao DATE NOT NULL,
    data_devolucao DATE,
    valor_multa FLOAT DEFAULT 0,
    status VARCHAR(30) NOT NULL DEFAULT 'ATIVO',
    id_usuario INT NOT NULL,
    id_equipamento INT NOT NULL,
    id_agendamento INT,

    FOREIGN KEY (id_usuario)
        REFERENCES usuario(id_usuario),
    FOREIGN KEY (id_equipamento)
        REFERENCES equipamento(id_equipamento),
    FOREIGN KEY (id_agendamento)
        REFERENCES agendamento(id_agendamento)
);

-- Tabela Checklist (extensão do grupo — RF14, RF15)
CREATE TABLE checklist (
    id_checklist INT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(20) NOT NULL,
    foto_url VARCHAR(255),
    observacao VARCHAR(255),
    data_registro DATETIME NOT NULL,
    id_emprestimo INT NOT NULL,

    FOREIGN KEY (id_emprestimo)
        REFERENCES emprestimo(id_emprestimo)
);

-- Tabela Manutenção
CREATE TABLE manutencao (
    id_manutencao INT PRIMARY KEY AUTO_INCREMENT,
    data_abertura DATE NOT NULL,
    data_encerramento DATE,
    descricao VARCHAR(255),
    tipo VARCHAR(20) NOT NULL,
    status VARCHAR(30) NOT NULL DEFAULT 'ABERTA',
    pecas_utilizadas VARCHAR(255),
    mao_de_obra FLOAT,
    custo_total FLOAT,
    id_equipamento INT NOT NULL,
    id_tecnico INT NOT NULL,

    FOREIGN KEY (id_equipamento)
        REFERENCES equipamento(id_equipamento),
    FOREIGN KEY (id_tecnico)
        REFERENCES usuario(id_usuario)
);

-- Tabela Tarifa (extensão do grupo — RF24)
CREATE TABLE tarifa (
    id_tarifa INT PRIMARY KEY AUTO_INCREMENT,
    diaria FLOAT NOT NULL,
    semanal FLOAT,
    quinzenal FLOAT,
    mensal FLOAT,
    id_equipamento INT NOT NULL UNIQUE,

    FOREIGN KEY (id_equipamento)
        REFERENCES equipamento(id_equipamento)
);
