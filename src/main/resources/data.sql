INSERT INTO autor(nome, email, descricao) VALUES ('José Autor', 'jose.autor@email.com', 'Descrição');
INSERT INTO autor(nome, email, descricao) VALUES ('Maria Autora', 'maria.autora@email.com', 'Descrição');

INSERT INTO categoria(nome) VALUES ('Desenvolvimento');
INSERT INTO categoria(nome) VALUES ('Testes');
INSERT INTO categoria(nome) VALUES ('Gerenciamento');

INSERT INTO livro (data_publicacao, isbn, numero_de_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id)
	VALUES ('2077-10-20','978-7-7575-6363-1',464,30.0,'Resumo do livro','Sumário do livro','Livro 1',1,1);
INSERT INTO livro (data_publicacao, isbn, numero_de_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id)
	VALUES ('2077-10-21','978-7-7575-6363-2',464,30.0,'Resumo do livro','Sumário do livro','Livro 2',1,2);
INSERT INTO livro (data_publicacao, isbn, numero_de_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id)
	VALUES ('2077-10-22','978-7-7575-6363-3',464,30.0,'Resumo do livro','Sumário do livro','Livro 3',1,3);
INSERT INTO livro (data_publicacao, isbn, numero_de_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id)
	VALUES ('2077-10-23','978-7-7575-6363-4',464,30.0,'Resumo do livro','Sumário do livro','Livro 4',2,1);
INSERT INTO livro (data_publicacao, isbn, numero_de_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id)
	VALUES ('2077-10-24','978-7-7575-6363-5',464,30.0,'Resumo do livro','Sumário do livro','Livro 5',2,2);
INSERT INTO livro (data_publicacao, isbn, numero_de_paginas, preco, resumo, sumario, titulo, autor_id, categoria_id)
	VALUES ('2077-10-25','978-7-7575-6363-6',464,30.0,'Resumo do livro','Sumário do livro','Livro 6',2,3);
