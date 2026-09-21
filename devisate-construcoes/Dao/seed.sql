-- Devisate Construções — Dados de teste
USE devisate_construcoes;

-- Usuários
INSERT INTO usuario (nome, email, senha, telefone, perfil) VALUES
('Administrador', 'admin@devisate.com', '123456', '(14) 99999-0000', 'ADMIN'),
('Carlos Silva', 'carlos@devisate.com', '123456', '(14) 99999-0001', 'FUNCIONARIO'),
('Marcos Souza', 'marcos@devisate.com', '123456', '(14) 99999-0002', 'RESPONSAVEL_OBRA'),
('Técnico João', 'joao.tecnico@devisate.com', '123456', '(14) 99999-0003', 'FUNCIONARIO');

-- Categorias
INSERT INTO categoria (nome, descricao) VALUES
('Furadeiras', 'Equipamentos de perfuração'),
('Betoneiras', 'Mistura de concreto'),
('Ferramentas Elétricas', 'Equipamentos elétricos diversos'),
('Compactação', 'Equipamentos de compactação de solo');

-- Equipamentos
INSERT INTO equipamento (nome, descricao, numero_serie, horimetro_inicial, horimetro_atual, status, id_categoria) VALUES
('Furadeira Bosch', 'Furadeira de impacto', 'FB-0001', 0, 120, 'DISPONIVEL', 1),
('Betoneira 400L', 'Betoneira para concreto', 'BT-0002', 0, 340, 'DISPONIVEL', 2),
('Serra Mármore', 'Serra elétrica para mármore', 'SM-0003', 0, 85, 'ALUGADO', 3),
('Compactador de Solo', 'Placa vibratória', 'CP-0004', 0, 500, 'EM_MANUTENCAO', 4);

-- Tarifas
INSERT INTO tarifa (diaria, semanal, quinzenal, mensal, id_equipamento) VALUES
(50, 300, 550, 1000, 1),
(80, 480, 900, 1600, 2),
(60, 360, 680, 1200, 3),
(70, 420, 800, 1400, 4);

-- Agendamentos
INSERT INTO agendamento (data_inicio, data_fim, obra_destino, finalidade, status, id_usuario, id_equipamento) VALUES
('2026-09-25', '2026-09-27', 'Obra Jardim Sul', 'Perfuração de parede', 'PENDENTE', 2, 1),
('2026-09-20', '2026-09-22', 'Obra Vila Nova', 'Corte de piso', 'APROVADO', 3, 3);

-- Empréstimos
INSERT INTO emprestimo (data_retirada, data_prevista_devolucao, data_devolucao, valor_multa, status, id_usuario, id_equipamento, id_agendamento) VALUES
('2026-09-15', '2026-09-18', '2026-09-18', 0, 'DEVOLVIDO', 2, 2, NULL),
('2026-09-18', '2026-09-20', NULL, 0, 'ATIVO', 3, 3, 2);

-- Checklists
INSERT INTO checklist (tipo, foto_url, observacao, data_registro, id_emprestimo) VALUES
('RETIRADA', '/fotos/emp1_retirada.jpg', 'Sem avarias', '2026-09-15 08:00:00', 1),
('DEVOLUCAO', '/fotos/emp1_devolucao.jpg', 'Sem avarias', '2026-09-18 17:00:00', 1),
('RETIRADA', '/fotos/emp2_retirada.jpg', 'Pequeno risco na lateral', '2026-09-18 09:00:00', 2);

-- Manutenções
INSERT INTO manutencao (data_abertura, data_encerramento, descricao, tipo, status, pecas_utilizadas, mao_de_obra, custo_total, id_equipamento, id_tecnico) VALUES
('2026-09-10', '2026-09-12', 'Troca de correia', 'CORRETIVA', 'ENCERRADA', 'Correia de transmissão', 80, 150, 4, 4),
('2026-09-19', NULL, 'Revisão preventiva por limite de horímetro', 'PREVENTIVA', 'ABERTA', NULL, NULL, NULL, 2, 4);
