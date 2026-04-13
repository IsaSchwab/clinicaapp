-- Queries do Dashboard — ClinicaApp

-- 1. Total de consultas por mês
SELECT 
    TO_CHAR(data_hora, 'YYYY-MM') AS mes,
    COUNT(*) AS total_consultas
FROM consultas
GROUP BY TO_CHAR(data_hora, 'YYYY-MM')
ORDER BY mes;

-- 2. Top médicos por atendimentos realizados
SELECT 
    m.nome AS medico,
    COUNT(c.id) AS total_atendimentos
FROM medicos m
JOIN consultas c ON c.medico_id = m.id
WHERE c.status = 'REALIZADA'
GROUP BY m.nome
ORDER BY total_atendimentos DESC;

-- 3. Taxa de cancelamento
SELECT
    COUNT(*) AS total_consultas,
    COUNT(CASE WHEN status = 'CANCELADA' THEN 1 END) AS canceladas,
    ROUND(
        COUNT(CASE WHEN status = 'CANCELADA' THEN 1 END) * 100.0 / COUNT(*),
        1
    ) AS taxa_cancelamento
FROM consultas;
