-- =================================================================
-- 1. LIMPEZA SEGURA (Evita erros de chave estrangeira)
-- =================================================================
DROP TABLE IF EXISTS tb_cardapio_itens CASCADE; -- Remove tabela legada se existir

DELETE FROM tb_categoria_item; 
DELETE FROM tb_categoria_cardapio;
DELETE FROM tb_cardapio;
DELETE FROM tb_registro_refeicao;
DELETE FROM tb_funcionario;
DELETE FROM tb_orders; -- Apaga pedidos antes de empresas (se houver vínculo futuro)
DELETE FROM tb_item;   -- Apaga itens por último nas tabelas filhas
DELETE FROM tb_empresa; -- Apaga empresas

-- =================================================================
-- 2. RESETAR CONTADORES (Para começar do ID 1)
-- =================================================================
ALTER SEQUENCE tb_item_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_orders_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_cardapio_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_empresa_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_funcionario_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_registro_refeicao_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_categoria_cardapio_id_seq RESTART WITH 1;

-- =================================================================
-- 3. INSERIR ITENS (PRIORIDADE: Precisam existir para serem usados)
-- =================================================================
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
INSERT INTO tb_item (nome, categoria) VALUES ('Heineken Long Neck', 'Bebida Alcoólica'); -- ID 19 (Adicionei este pois o ID 19 é usado abaixo)
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

-- =================================================================
-- 4. INSERIR CARDÁPIOS E CATEGORIAS
-- =================================================================
INSERT INTO tb_cardapio (id, nome, descricao, ativo, turno_padrao) 
VALUES (1, 'Almoço Executivo', 'Opções variadas para o dia a dia da empresa.', true, 'ALMOCO');

INSERT INTO tb_cardapio (id, nome, descricao, ativo, turno_padrao) 
VALUES (2, 'Jantar', 'Jantar', false, 'JANTAR');

-- Categorias do Cardápio 1
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (1, 'Prato Principal', 1, 1);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (2, 'Guarnições', 2, 1);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (3, 'Bebidas', 1, 1);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (4, 'Sobremesa', 1, 1);

-- Categorias do Cardápio 2
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (5, 'Massa', 1, 2);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (6, 'Bebidas', 2, 2);

-- =================================================================
-- 5. VINCULAR ITENS ÀS CATEGORIAS (Agora funciona pois os itens já existem)
-- =================================================================
-- Prato Principal (ID 1)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 4); -- Filé de Frango
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 5); -- Bife Acebolado
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 6); -- Strogonoff

-- Guarnições (ID 2)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 1); -- Arroz Branco
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 2); -- Feijão Carioca
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 3); -- Batata Frita
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 11); -- Farofa
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 10); -- Salada Maionese

-- Bebidas Almoço (ID 3)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 12); -- Coca
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 13); -- Guaraná
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 14); -- Suco Laranja
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 17); -- Água c/ gas

-- Sobremesa (ID 4)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (4, 20); -- Pudim
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (4, 21); -- Mousse

-- Massa Jantar (ID 5)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (5, 7); -- Lasanha
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (5, 8); -- Espaguete

-- Bebidas Jantar (ID 6)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (6, 12); -- Coca
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (6, 19); -- Heineken (Item criado acima)

-- =================================================================
-- 6. DADOS GERAIS (Empresas, Funcionários, Pedidos)
-- =================================================================
INSERT INTO tb_empresa (id, nome, cnpj) VALUES (1, 'Construtora Forte', '98.765.432/0001-10');
INSERT INTO tb_empresa (id, nome, cnpj) VALUES (2, 'RAM Engenharia e Demolição Vertical', '33.333.333/0001-33');
INSERT INTO tb_empresa (id, nome, cnpj) VALUES (3, 'Construtora Horizonte', '44.444.444/0001-44');

INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('Carlos P', '11111111111', 'Engenheiro', 2);
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('João Silva', '22222222222', 'Engenheiro', 1);
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('Maria Souza', '33333333333', 'Arquiteta', 3);
INSERT INTO tb_funcionario (nome, cpf, cargo, empresa_id) VALUES ('Ana Costa', '44444444444', 'Arquiteta', 3);

INSERT INTO tb_orders (obra, gestor, qtd_marmitas, status) VALUES ('Torre Corporativa Delta', 'Fernanda Lima', 85, 'Recebido');
INSERT INTO tb_orders (obra, gestor, qtd_marmitas, status) VALUES ('Residencial das Flores', 'Ricardo Almeida', 40, 'Em preparo');
INSERT INTO tb_orders (obra, gestor, qtd_marmitas, status) VALUES ('Shopping Metropolitano', 'Juliana Santos', 250, 'Enviado');
INSERT INTO tb_orders (obra, gestor, qtd_marmitas, status) VALUES ('Viaduto Central', 'Márcio Ribeiro', 150, 'Finalizado');
-- (Pode manter o resto dos seus inserts de orders aqui...)

-- =================================================================
-- 7. ATUALIZAÇÃO FINAL DE SEQUENCES
-- =================================================================
ALTER SEQUENCE tb_cardapio_id_seq RESTART WITH 3;
ALTER SEQUENCE tb_categoria_cardapio_id_seq RESTART WITH 7;
-- Importante: como inserimos itens, precisamos atualizar a sequence de itens também
-- O valor 40 é uma estimativa segura baseada na quantidade de itens inseridos acima
ALTER SEQUENCE tb_item_id_seq RESTART WITH 40;