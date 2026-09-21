-- Devisate Construções — Consultas de validação
USE devisate_construcoes;

-- Listar todos os equipamentos
SELECT * FROM equipamento;

-- Listar equipamentos com sua categoria
SELECT
    e.nome AS equipamento,
    c.nome AS categoria,
    e.status
FROM equipamento e
INNER JOIN categoria c ON e.id_categoria = c.id_categoria;

-- Listar empréstimos por usuário
SELECT
    u.nome AS usuario,
    emp.data_retirada,
    emp.data_prevista_devolucao,
    emp.status
FROM emprestimo emp
INNER JOIN usuario u ON emp.id_usuario = u.id_usuario;

-- Listar equipamentos atualmente em manutenção
SELECT nome, status
FROM equipamento
WHERE status = 'EM_MANUTENCAO';

-- Verificar conflito de agendamento para um equipamento em um período
-- (usado antes de inserir um novo agendamento — RF12)
SELECT *
FROM agendamento
WHERE id_equipamento = 3
  AND status IN ('PENDENTE', 'APROVADO')
  AND NOT (data_fim < '2026-09-25' OR data_inicio > '2026-09-27');

-- Histórico completo de um equipamento: empréstimos e manutenções (RF09)
SELECT 'EMPRESTIMO' AS tipo_registro, data_retirada AS data, status
FROM emprestimo
WHERE id_equipamento = 3
UNION ALL
SELECT 'MANUTENCAO' AS tipo_registro, data_abertura AS data, status
FROM manutencao
WHERE id_equipamento = 3
ORDER BY data;

-- Indicadores do dashboard: quantidade de equipamentos por status (RF21)
SELECT status, COUNT(*) AS quantidade
FROM equipamento
GROUP BY status;

-- Ranking de equipamentos mais utilizados (RF22)
SELECT
    e.nome,
    COUNT(emp.id_emprestimo) AS total_emprestimos
FROM equipamento e
LEFT JOIN emprestimo emp ON emp.id_equipamento = e.id_equipamento
GROUP BY e.id_equipamento
ORDER BY total_emprestimos DESC;

-- Custos de manutenção por equipamento (RF23)
SELECT
    e.nome,
    SUM(m.custo_total) AS custo_total_manutencao
FROM manutencao m
INNER JOIN equipamento e ON m.id_equipamento = e.id_equipamento
WHERE m.status = 'ENCERRADA'
GROUP BY e.id_equipamento;
