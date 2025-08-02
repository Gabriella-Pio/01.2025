/*Caso necessário apagar as tabelas:*/
/
drop table cliente, forma_pg, item_venda, op_caixa, produto, supervisor, tipo_venda, venda cascade;
drop table venda cascade;  
drop table *;
 */


/*1. CRIAÇÃO DAS TABELAS DO PROJETO*/

/*Criação Tabela cliente*/
CREATE TABLE public.cliente (
	id_cliente serial4 NOT NULL,
	p_nome varchar NOT NULL,
	sobrenome varchar NOT NULL,
	data_nasc date NOT NULL,
	saldo_cred numeric NOT NULL,
	cpf bpchar(11) NOT NULL
);

/*Criação Tabela supervisor */
CREATE TABLE public.supervisor (
	id_supervisor serial4 NOT NULL,
	p_nome varchar NOT NULL,
	sobrenome varchar NOT NULL,
	data_nasc date NOT NULL,
	senha_usuario varchar NOT NULL
);

/*Criação Tabela produto */
CREATE TABLE public.produto (
	id_produto serial4 NOT NULL,
	disponivel bool NOT NULL,
	preco numeric NOT NULL,
	descricao varchar NOT NULL
);

/*Criação Tabela item_venda */
CREATE TABLE public.item_venda (
	id_item serial4 NOT NULL,
	quantidade int4 NOT NULL,
	valor_unit numeric NOT NULL,
	id_produto int4 null,
	id_venda int4 null,
	valor_total numeric
); 

/*Criação Tabela forma_pg */
CREATE TABLE public.forma_pg (
	id_forma_pg serial4 NOT NULL,
	descricao varchar NOT NULL,
	ativo bool NOT NULL,
	taxa numeric not null
);

/*Criação Tabela tipo_venda*/
CREATE TABLE public.tipo_venda (
	id_tipo_venda serial4 NOT NULL,
	descricao varchar NOT NULL,
	ativo bool NOT NULL,
	tempo_limite int4 not NULL
);

/* Criação da tabela op_caixa*/
CREATE TABLE public.op_caixa (
    id_operador serial4 NOT NULL,
    p_nome varchar NOT NULL,
    sobrenome varchar NOT NULL,
    data_nasc date NOT NULL,
    senha_usuario varchar NOT NULL,
    id_supervisor int4 NULL
);

/*Criação Tabela venda*/
CREATE TABLE public.venda (
	id_venda serial4 NOT NULL,
	valor_total numeric NOT NULL,
	data_venda timestamp NOT NULL,
	cliente_vinculado bool NOT NULL,
	pago bool NOT null,
	entregue bool NOT null,
	id_cliente int4 NULL,
	id_operador int4 NULL,
	id_item int4 NULL,
	id_tipo_venda int4 NULL,
	id_forma_pg int4 NULL
);


/*2. CRIAÇÃO DAS CHAVES PRIMÁRIAS E ESTRANGEIRAS DAS TABELAS*/

alter table public.cliente 
add CONSTRAINT cliente_pk PRIMARY KEY (id_cliente),
add CONSTRAINT cliente_unique UNIQUE (cpf);

alter table public.supervisor 
add CONSTRAINT supervisor_pk PRIMARY KEY (id_supervisor);

alter table public.produto
add CONSTRAINT produto_pk PRIMARY KEY (id_produto);

alter table public.forma_pg 
add	CONSTRAINT forma_pg_pk PRIMARY KEY (id_forma_pg);

alter table public.tipo_venda 
add	CONSTRAINT tipo_venda_pk PRIMARY KEY (id_tipo_venda);

alter table public.op_caixa 
add CONSTRAINT op_caixa_pk PRIMARY KEY (id_operador),
add CONSTRAINT op_caixa_supervisor_fk FOREIGN KEY (id_supervisor) REFERENCES public.supervisor(id_supervisor);

alter table public.venda 
add CONSTRAINT venda_pk PRIMARY KEY (id_venda),
add	CONSTRAINT venda_cliente_fk FOREIGN KEY (id_cliente) REFERENCES public.cliente(id_cliente),
add	CONSTRAINT venda_forma_pg_fk FOREIGN KEY (id_forma_pg) REFERENCES public.forma_pg(id_forma_pg),
add	CONSTRAINT venda_op_caixa_fk FOREIGN KEY (id_operador) REFERENCES public.op_caixa(id_operador),
add	CONSTRAINT venda_tipo_venda_fk FOREIGN KEY (id_tipo_venda) REFERENCES public.tipo_venda(id_tipo_venda);


alter table public.item_venda
add CONSTRAINT item_venda_pk PRIMARY KEY (id_item),
add CONSTRAINT item_venda_produto_fk FOREIGN KEY (id_produto) REFERENCES public.produto(id_produto),
add CONSTRAINT item_venda_venda_fk FOREIGN KEY (id_venda) REFERENCES public.venda(id_venda),
ADD CONSTRAINT produto_venda UNIQUE (id_produto, id_venda);

/*Trigger para calcular o valor total da venda, de acordo com */
CREATE OR REPLACE FUNCTION atualiza_total_venda()
RETURNS TRIGGER AS $$
BEGIN
    -- Atualiza o total na tabela venda baseado nos itens associados
    UPDATE venda
    SET valor_total = (
        SELECT COALESCE(SUM(valor_unit * quantidade), 0)
        FROM item_venda
        WHERE id_venda = NEW.id_venda
    )
    WHERE id_venda = NEW.id_venda;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualiza_venda
AFTER INSERT OR UPDATE OR DELETE
ON item_venda
FOR EACH ROW
EXECUTE FUNCTION atualiza_total_venda();

/*Trigger para calcular o valor total do item, de acordo com a quantidade*/
CREATE OR REPLACE FUNCTION atualiza_total_item_venda()
RETURNS TRIGGER AS $$
BEGIN
    -- Calcula o valor total diretamente
    NEW.valor_total := NEW.valor_unit * NEW.quantidade;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualiza_item_venda
BEFORE INSERT OR UPDATE
ON item_venda
FOR EACH ROW
EXECUTE FUNCTION atualiza_total_item_venda();

/*3. INSERIR 5 REGISTROS EM CADA TABELA*/

/*Inserção de Dados*/
INSERT INTO public.cliente (p_nome, sobrenome, cpf, data_nasc, saldo_cred)
VALUES 
('Ana', 'Silva', '12345678901', '2000-01-01', 100.50),
('Carlos', 'Pereira', '23456789012', '1995-05-15', 200.00),
('Beatriz', 'Souza', '34567890123', '1988-09-23', 150.75),
('Daniel', 'Oliveira', '45678901234', '1990-12-12', 50.00),
('Fernanda', 'Santos', '56789012345', '2002-07-07', 300.25);

INSERT INTO public.supervisor (p_nome, sobrenome, data_nasc, senha_usuario)
VALUES 
('Mariana', 'Lima', '1980-01-01', 'sup123'),
('Roberto', 'Vieira', '1975-10-10', 'sup456'),
('Juliana', 'Farias', '1983-03-03', 'sup789'),
('Renato', 'Barros', '1979-09-09', 'sup321'),
('Patrícia', 'Teixeira', '1985-07-07', 'sup654');

INSERT INTO public.produto (descricao, preco, disponivel)
VALUES 
('Coxinha', 5.00, true),
('Refrigerante', 7.50, true),
('Pão de Queijo', 4.00, true),
('Pastel', 6.50, true),
('Suco Natural', 8.00, true);


INSERT INTO public.forma_pg (descricao, ativo, taxa)
VALUES 
('Dinheiro', true, 0.00),
('Cartão de Crédito', true, 0.05),
('Cartão de Débito', true, 0.00),
('Pix', true, 0.00),
('Crediário', false, 0.00);

INSERT INTO public.tipo_venda (descricao, tempo_limite, ativo)
VALUES 
('Presencial', 0, true),
('Recarga', 1, false),
('Compra com saldo', 0, true),
('Para levar', 0, true),
('Agendamento', 5, true);

INSERT INTO public.op_caixa (p_nome, sobrenome, data_nasc, senha_usuario, id_supervisor)
VALUES 
('João', 'Martins', '1990-02-10', 'senha123', 5),
('Maria', 'Fernandes', '1985-08-05', 'senha456', 3),
('Lucas', 'Almeida', '1992-11-30', 'senha789', 5),
('Paula', 'Silveira', '1998-03-20', 'senha321', 3),
('Rafael', 'Costa', '1987-06-25', 'senha654', 5);

INSERT INTO public.venda (data_venda, valor_total, cliente_vinculado, pago, entregue, id_cliente, id_operador, id_forma_pg, id_tipo_venda)
VALUES 
('2025-05-16', 0.00, true, true, false, 1, 1, 1, 5),
('2025-05-15', 0.00, false, true, true, null, 2, 2, 2),
('2025-05-14', 0.00, true, false, false, 3, 3, 3, 3),
('2025-05-13', 0.00, false, true, true, null, 4, 4, 4),
('2025-05-12', 0.00, true, false, false, 5, 5, 5, 5);

INSERT INTO public.item_venda (id_produto, id_venda, quantidade, valor_unit)
VALUES 
(1, 1, 2, 5.00),
(2, 2, 1, 7.50),
(3, 3, 1, 4.00),
(4, 4, 2, 6.50),
(5, 5, 1, 8.00);


/*4. ALTERAR UM DADO QUALQUER EM ALGUMA TABELA*/

/*Alteração de um produto*/
UPDATE public.produto
SET disponivel=true, preco=4.00, descricao='Água Gaseificada'
WHERE id_produto=2;


/*5. EXCLUIR UM DADO QUALQUER EM ALGUMA TABELA*/

/*Exclusão de um registro da tabela supervisor*/
DELETE FROM public.supervisor
WHERE id_supervisor=2;


/*6. INSTRUÇÃO COM COMANDO SELECT*/

/*Comando SELECT para verificar as vendas não entregues*/
SELECT * FROM public.venda WHERE entregue IS false;


/*7. INSTRUÇÃO COM COMANDO INNER join*/

/*Comando INNER JOIN para exibir as vendas por operador*/
SELECT 
    v.id_venda,
    v.data_venda,
    v.valor_total,
    v.cliente_vinculado,
    o.p_nome AS operador_nome,
    o.sobrenome AS operador_sobrenome
FROM 
    public.venda v
INNER JOIN 
    public.op_caixa o
ON 
    v.id_operador = o.id_operador;


/*8. INSTRUÇÃO COM COMANDO LEFT join*/

/*Comando LEFT JOIN para exibir os supervisores sem operadores*/
SELECT 
    public.supervisor.id_supervisor,
    public.supervisor.p_nome,
	public.supervisor.sobrenome, 
	public.op_caixa .p_nome,
	public.op_caixa .sobrenome,
    public.op_caixa.id_operador
FROM 
    public.supervisor
LEFT JOIN 
    public.op_caixa 
ON 
    public.supervisor.id_supervisor = public.op_caixa.id_supervisor
WHERE 
    public.op_caixa.id_operador IS NULL;


/*9. INSTRUÇÃO COM COMANDO RIGHT join*/

/*Comando RIGHT JOIN para exibir as vendas por tipo*/
SELECT 
    public.tipo_venda.id_tipo_venda,
    public.tipo_venda.descricao,
    public.venda.id_venda,
    public.venda.valor_total,
    public.venda.data_venda
FROM 
    public.tipo_venda
RIGHT JOIN 
    public.venda
ON 
    public.tipo_venda.id_tipo_venda = public.venda.id_tipo_venda
WHERE 
    public.tipo_venda.descricao = 'Agendamento';

