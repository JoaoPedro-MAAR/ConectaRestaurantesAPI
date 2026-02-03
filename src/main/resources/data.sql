-- Limpa a tabela para garantir que não haja duplicatas ao reiniciar
DELETE FROM tb_solicitacao;

-- Insere 30 registros de exemplo na tabela 'tb_orders'
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
-- 1. LIMPEZA SEGURA
-- =================================================================
DROP TABLE IF EXISTS tb_cardapio_itens CASCADE; -- Remove tabela legada

-- Adicione essa linha aqui para limpar os vínculos de pratos feitos antes de apagar os itens
DELETE FROM tb_prato_composicao; 

DELETE FROM tb_categoria_item; 
DELETE FROM tb_categoria_cardapio;
DELETE FROM tb_cardapio;
DELETE FROM tb_registro_refeicao;
DELETE FROM tb_funcionario;
DELETE FROM tb_orders;
DELETE FROM tb_item;   
DELETE FROM tb_empresa;

-- =================================================================
-- 2. RESETAR CONTADORES
-- =================================================================
ALTER SEQUENCE tb_item_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_orders_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_cardapio_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_empresa_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_funcionario_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_registro_refeicao_id_seq RESTART WITH 1;
ALTER SEQUENCE tb_categoria_cardapio_id_seq RESTART WITH 1;

-- =================================================================
-- 3. INSERIR ITENS
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

-- =================================================================
-- 4. INSERIR CARDÁPIOS
-- =================================================================
INSERT INTO tb_cardapio (id, nome, descricao, ativo, turno_padrao) 
VALUES (1, 'Almoço Executivo', 'Opções variadas para o dia a dia da empresa.', true, 'ALMOCO');

INSERT INTO tb_cardapio (id, nome, descricao, ativo, turno_padrao) 
VALUES (2, 'Jantar', 'Jantar', false, 'JANTAR'); -- Corrigido para false

-- Categorias do Cardápio 1
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (1, 'Prato Principal', 1, 1);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (2, 'Guarnições', 2, 1);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (3, 'Bebidas', 1, 1);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (4, 'Sobremesa', 1, 1);

-- Categorias do Cardápio 2
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (5, 'Massa', 1, 2);
INSERT INTO tb_categoria_cardapio (id, nome, limite_maximo_escolhas, cardapio_id) VALUES (6, 'Bebidas', 2, 2);

-- =================================================================
-- 5. VINCULAR ITENS
-- =================================================================
-- Prato Principal (ID 1)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 4); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 5); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (1, 6); 

-- Guarnições (ID 2)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 1); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 2); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 3); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 11); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (2, 10); 

-- Bebidas Almoço (ID 3)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 12); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 13); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 14); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (3, 17); 

-- Sobremesa (ID 4)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (4, 20); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (4, 21); 

-- Massa Jantar (ID 5)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (5, 7); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (5, 8); 

-- Bebidas Jantar (ID 6)
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (6, 12); 
INSERT INTO tb_categoria_item (categoria_id, item_id) VALUES (6, 19); 

-- =================================================================
-- 6. DADOS GERAIS
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
-- Mantenha seus outros inserts de orders...

-- =================================================================
-- 7. ATUALIZAÇÃO FINAL DE SEQUENCES
-- =================================================================
ALTER SEQUENCE tb_cardapio_id_seq RESTART WITH 3;
ALTER SEQUENCE tb_categoria_cardapio_id_seq RESTART WITH 7;
ALTER SEQUENCE tb_item_id_seq RESTART WITH 40;