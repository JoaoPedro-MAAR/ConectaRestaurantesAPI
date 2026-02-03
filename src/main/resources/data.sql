-- =================================================================
-- 1. LIMPEZA SEGURA (ORDEM CORRETA: FILHOS -> PAIS)
-- =================================================================
DELETE FROM tb_pedidos_itens;
DELETE FROM tb_categoria_item;
DELETE FROM tb_prato_composicao;

-- Tabelas Dependentes
DELETE FROM tb_pedidos;
DELETE FROM tb_categoria_cardapio;
DELETE FROM tb_registro_refeicao;

-- Tabelas Principais
DELETE FROM tb_solicitacao;
DELETE FROM tb_cardapio;
DELETE FROM tb_funcionario;
DELETE FROM tb_item;
DELETE FROM tb_empresa;

-- =================================================================
-- 2. RESETAR CONTADORES (SEQUENCES)
-- =================================================================
ALTER SEQUENCE tb_item_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_solicitacao_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_pedidos_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_cardapio_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_empresa_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_funcionario_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_registro_refeicao_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_categoria_cardapio_id_seq RESTART WITH 1;

-- =================================================================
-- 3. INSERIR DADOS GERAIS (BASE)
-- =================================================================
-- Itens do Cardápio
INSERT INTO tb_item (nome, categoria) VALUES ('Arroz Branco', 'Acompanhamento'); -- ID 1
INSERT INTO tb_item (nome, categoria) VALUES ('Feijão Carioca', 'Acompanhamento'); -- ID 2
INSERT INTO tb_item (nome, categoria) VALUES ('Batata Frita', 'Porção'); -- ID 3
INSERT INTO tb_item (nome, categoria) VALUES ('Filé de Frango Grelhado', 'Prato Principal'); -- ID 4
INSERT INTO tb_item (nome, categoria) VALUES ('Bife Acebolado', 'Prato Principal'); -- ID 5
INSERT INTO tb_item (nome, categoria) VALUES ('Strogonoff de Carne', 'Prato Principal'); -- ID 6
INSERT INTO tb_item (nome, categoria) VALUES ('Lasanha à Bolonhesa', 'Massas'); -- ID 7
INSERT INTO tb_item (nome, categoria) VALUES ('Espaguete ao Sugo', 'Massas'); -- ID 8
INSERT INTO tb_item (nome, categoria) VALUES ('Salada Ceasar', 'Entrada'); -- ID 9
INSERT INTO tb_item (nome, categoria) VALUES ('Salada de Maionese', 'Acompanhamento'); -- ID 10
INSERT INTO tb_item (nome, categoria) VALUES ('Farofa de Bacon', 'Acompanhamento'); -- ID 11
INSERT INTO tb_item (nome, categoria) VALUES ('Coca-Cola 350ml', 'Bebida'); -- ID 12
INSERT INTO tb_item (nome, categoria) VALUES ('Guaraná Antarctica', 'Bebida'); -- ID 13
INSERT INTO tb_item (nome, categoria) VALUES ('Suco de Laranja Natural', 'Bebida'); -- ID 14
INSERT INTO tb_item (nome, categoria) VALUES ('Suco de Limão', 'Bebida'); -- ID 15
INSERT INTO tb_item (nome, categoria) VALUES ('Água Mineral sem Gás', 'Bebida'); -- ID 16
INSERT INTO tb_item (nome, categoria) VALUES ('Água com Gás', 'Bebida'); -- ID 17
INSERT INTO tb_item (nome, categoria) VALUES ('Cerveja Heineken', 'Bebida Alcoólica'); -- ID 18
INSERT INTO tb_item (nome, categoria) VALUES ('Heineken Long Neck', 'Bebida Alcoólica'); -- ID 19
INSERT INTO tb_item (nome, categoria) VALUES ('Pudim de Leite', 'Sobremesa'); -- ID 20
INSERT INTO tb_item (nome, categoria) VALUES ('Mousse de Maracujá', 'Sobremesa'); -- ID 21
INSERT INTO tb_item (nome, categoria) VALUES ('Petit Gateau', 'Sobremesa');
INSERT INTO tb_item (nome, categoria) VALUES ('Sorvete de Creme', 'Sobremesa');
INSERT INTO tb_item (nome, categoria) VALUES ('Hambúrguer Artesanal', 'Lanche');
INSERT INTO tb_item (nome, categoria) VALUES ('X-Bacon', 'Lanche');
INSERT INTO tb_item (nome, categoria) VALUES ('Pastel de Carne', 'Entrada');
INSERT INTO tb_item (nome, categoria) VALUES ('Pastel de Queijo', 'Entrada');
INSERT INTO tb_item (nome, categoria) VALUES ('Bolinho de Bacalhau', 'Entrada');
INSERT INTO tb_item (nome, categoria) VALUES ('Tábua de Frios', 'Porção');
INSERT INTO tb_item (nome, categoria) VALUES ('Isca de Peixe', 'Porção');
INSERT INTO tb_item (nome, categoria) VALUES ('Café Expresso', 'Bebida');

-- Empresas
INSERT INTO tb_empresa (id, nome, cnpj) VALUES (1, 'Construtora Forte', '98.765.432/0001-10');
INSERT INTO tb_empresa (id, nome, cnpj) VALUES (2, 'RAM Engenharia e Demolição Vertical', '33.333.333/0001-33');
INSERT INTO tb_empresa (id, nome, cnpj) VALUES (3, 'Construtora Horizonte', '44.444.444/0001-44');

-- Funcionários
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('Carlos P', '11111111111', 'Engenheiro', 2);
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('João Silva', '22222222222', 'Engenheiro', 1);
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('Maria Souza', '33333333333', 'Arquiteta', 3);
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('Ana Costa', '44444444444', 'Arquiteta', 3);

-- =================================================================
-- 4. INSERIR CARDÁPIOS
-- =================================================================
INSERT INTO tb_cardapio (id, nome, descricao, ativo, turno_padrao)
VALUES (1, 'Almoço Executivo', 'Opções variadas para o dia a dia da empresa.', true, 'ALMOCO');

INSERT INTO tb_cardapio (id, nome, descricao, ativo, turno_padrao)
VALUES (2, 'Jantar', 'Jantar', false, 'JANTAR');

-- Categorias e Itens do Cardápio
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (1, 'Prato Principal', 1, 1);
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 4), (1, 5), (1, 6);

INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (2, 'Guarnições', 2, 1);
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 1), (2, 2), (2, 3), (2, 11), (2, 10);

INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (3, 'Bebidas', 1, 1);
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 12), (3, 13), (3, 14), (3, 17);

INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (4, 'Sobremesa', 1, 1);
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (4, 20), (4, 21);

INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (5, 'Massa', 1, 2);
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (5, 7), (5, 8);

INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (6, 'Bebidas', 2, 2);
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (6, 12), (6, 19);

-- =================================================================
-- 5. INSERIR SOLICITAÇÕES (Total: 30)
-- =================================================================
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Torre Corporativa Delta', 'Fernanda Lima', 85, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Residencial das Flores', 'Ricardo Almeida', 40, 'Em preparo');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Shopping Metropolitano', 'Juliana Santos', 250, 'Enviado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Viaduto Central', 'Márcio Ribeiro', 150, 'Finalizado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Hospital São Lucas', 'Beatriz Costa', 180, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Escola Municipal Aprender', 'Lucas Martins', 60, 'Cancelado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Condomínio Vista Verde', 'Camila Pereira', 75, 'Em preparo');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Parque Ecológico da Cidade', 'Gustavo Oliveira', 30, 'Enviado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Centro de Convenções', 'Larissa Ferreira', 300, 'Finalizado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Estação de Metrô Linha Azul', 'Rodrigo Gomes', 220, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Edifício Platinum', 'Sofia Mendes', 95, 'Em preparo');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Ginásio Poliesportivo', 'Thiago Rocha', 110, 'Cancelado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Praça da Liberdade', 'Amanda Souza', 25, 'Enviado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Complexo Industrial Alfa', 'Daniel Barbosa', 400, 'Finalizado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Biblioteca Pública Estadual', 'Isabela Castro', 55, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Teatro Municipal', 'Vinícius Dias', 45, 'Em preparo');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Resort Águas Claras', 'Gabriela Azevedo', 130, 'Enviado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Ponte sobre o Rio Seco', 'Felipe Nunes', 160, 'Finalizado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Universidade Federal - Campus II', 'Mariana Pinto', 280, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Aeroporto Internacional', 'Leonardo Cunha', 500, 'Cancelado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Edifício Comercial Ômega', 'Patrícia Melo', 115, 'Em preparo');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Museu de Arte Moderna', 'Eduardo Neves', 35, 'Enviado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Terminal Rodoviário', 'Vanessa Teixeira', 190, 'Finalizado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Conjunto Habitacional Sol Nascente', 'Rafael Viana', 350, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Estádio de Futebol Arena do Povo', 'Cláudia Ramos', 600, 'Em preparo');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Centro Administrativo do Estado', 'Sérgio Moraes', 240, 'Cancelado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Usina Hidrelétrica', 'Renata Farias', 700, 'Enviado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Linha de Transmissão de Energia', 'Anderson Barros', 80, 'Finalizado');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Porto Marítimo de Cargas', 'Tatiane Correia', 450, 'Recebido');
INSERT INTO tb_solicitacao (obra, gestor, qtd_marmitas, status) VALUES ('Parque Aquático Paraíso', 'Diego Freire', 140, 'Em preparo');

-- =================================================================
-- 6. INSERIR PEDIDOS (Total: 30 - Um para cada solicitação)
-- =================================================================
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (1, 'ABERTO', 'Sem cebola na salada', 1, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (2, 'PRONTO', NULL, 2, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (3, 'ENTREGUE', 'Carne bem passada', 3, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (4, 'ABERTO', 'Trocar fritas por purê', 4, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (5, 'CANCELADO', 'Pedido duplicado', 5, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (6, 'EM_PREPARO', NULL, 6, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (7, 'PRONTO', 'Trazer sachê de maionese', 7, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (8, 'ENTREGUE', NULL, 8, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (9, 'ABERTO', 'Suco sem açúcar', 9, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (10, 'EM_PREPARO', NULL, 10, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (11, 'ENTREGUE', 'Entrega na portaria B', 11, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (12, 'ABERTO', NULL, 12, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (13, 'CANCELADO', 'Cliente desistiu', 13, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (14, 'PRONTO', NULL, 14, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (15, 'EM_PREPARO', 'Dobro de feijão', 15, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (16, 'ENTREGUE', NULL, 16, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (17, 'ABERTO', 'Coca com gelo e limão', 17, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (18, 'PRONTO', NULL, 18, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (19, 'ENTREGUE', NULL, 19, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (20, 'CANCELADO', NULL, 20, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (21, 'ABERTO', 'Molho separado', 21, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (22, 'EM_PREPARO', NULL, 22, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (23, 'PRONTO', NULL, 23, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (24, 'ENTREGUE', 'Cuidado, frágil', 24, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (25, 'ABERTO', NULL, 25, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (26, 'EM_PREPARO', 'Sem salada', 26, 2);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (27, 'PRONTO', NULL, 27, 3);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (28, 'ENTREGUE', NULL, 28, 4);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (29, 'ABERTO', 'Com bastante farofa', 29, 1);
INSERT INTO tb_pedidos (id, status, observacao, solicitacao_id, funcionario_id) VALUES (30, 'EM_PREPARO', NULL, 30, 2);

-- Atualiza sequência para não dar erro ao criar novos (Agora começa do 31)
ALTER SEQUENCE tb_pedidos_id_seq RESTART WITH 31;


-- =================================================================
-- 7. VINCULAR ITENS AOS PEDIDOS
-- =================================================================
-- Pedido 1
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (1, 1), (1, 2), (1, 4), (1, 12);
-- Pedido 2
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (2, 7), (2, 14), (2, 20);
-- Pedido 3
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (3, 5), (3, 3), (3, 16);
-- Pedido 4
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (4, 6), (4, 1), (4, 3);
-- Pedido 6
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (6, 25), (6, 12);
-- Pedido 7
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (7, 8), (7, 18);
-- Pedido 8
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (8, 9), (8, 15);
-- Pedido 9
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (9, 24), (9, 3);
-- Pedido 10
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) VALUES (10, 30), (10, 19);

-- Padrão para os demais
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) SELECT id, 1 FROM tb_pedidos WHERE id > 10;
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) SELECT id, 2 FROM tb_pedidos WHERE id > 10;
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) SELECT id, 4 FROM tb_pedidos WHERE id > 10 AND id % 2 = 0;
INSERT INTO tb_pedidos_itens (pedido_id, itens_id) SELECT id, 5 FROM tb_pedidos WHERE id > 10 AND id % 2 <> 0;

-- =================================================================
-- 8. ATUALIZAÇÕES FINAIS
-- =================================================================
ALTER SEQUENCE tb_cardapio_id_seq RESTART WITH 3;
ALTER SEQUENCE tb_categoria_cardapio_id_seq RESTART WITH 7;
ALTER SEQUENCE tb_item_id_seq RESTART WITH 40;
ALTER SEQUENCE tb_pedidos_id_seq RESTART WITH 31; -- Ajustado para 31