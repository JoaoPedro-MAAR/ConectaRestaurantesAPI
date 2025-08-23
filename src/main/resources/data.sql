-- Limpa a tabela para garantir que não haja duplicatas ao reiniciar
DELETE FROM orders;

-- Insere 30 registros de exemplo na tabela 'orders'
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Torre Corporativa Delta', 'Fernanda Lima', 85, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Residencial das Flores', 'Ricardo Almeida', 40, 'Em preparo');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Shopping Metropolitano', 'Juliana Santos', 250, 'Enviado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Viaduto Central', 'Márcio Ribeiro', 150, 'Finalizado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Hospital São Lucas', 'Beatriz Costa', 180, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Escola Municipal Aprender', 'Lucas Martins', 60, 'Cancelado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Condomínio Vista Verde', 'Camila Pereira', 75, 'Em preparo');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Parque Ecológico da Cidade', 'Gustavo Oliveira', 30, 'Enviado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Centro de Convenções', 'Larissa Ferreira', 300, 'Finalizado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Estação de Metrô Linha Azul', 'Rodrigo Gomes', 220, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Edifício Platinum', 'Sofia Mendes', 95, 'Em preparo');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Ginásio Poliesportivo', 'Thiago Rocha', 110, 'Cancelado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Praça da Liberdade', 'Amanda Souza', 25, 'Enviado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Complexo Industrial Alfa', 'Daniel Barbosa', 400, 'Finalizado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Biblioteca Pública Estadual', 'Isabela Castro', 55, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Teatro Municipal', 'Vinícius Dias', 45, 'Em preparo');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Resort Águas Claras', 'Gabriela Azevedo', 130, 'Enviado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Ponte sobre o Rio Seco', 'Felipe Nunes', 160, 'Finalizado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Universidade Federal - Campus II', 'Mariana Pinto', 280, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Aeroporto Internacional', 'Leonardo Cunha', 500, 'Cancelado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Edifício Comercial Ômega', 'Patrícia Melo', 115, 'Em preparo');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Museu de Arte Moderna', 'Eduardo Neves', 35, 'Enviado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Terminal Rodoviário', 'Vanessa Teixeira', 190, 'Finalizado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Conjunto Habitacional Sol Nascente', 'Rafael Viana', 350, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Estádio de Futebol Arena do Povo', 'Cláudia Ramos', 600, 'Em preparo');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Centro Administrativo do Estado', 'Sérgio Moraes', 240, 'Cancelado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Usina Hidrelétrica', 'Renata Farias', 700, 'Enviado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Linha de Transmissão de Energia', 'Anderson Barros', 80, 'Finalizado');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Porto Marítimo de Cargas', 'Tatiane Correia', 450, 'Recebido');
INSERT INTO orders (obra, gestor, qtd_marmitas, status) VALUES ('Parque Aquático Paraíso', 'Diego Freire', 140, 'Em preparo');