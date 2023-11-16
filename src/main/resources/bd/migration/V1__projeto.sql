-- Create ulid functions -------------------------------------------------

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION ulid() RETURNS uuid
    AS $$
SELECT (lpad(to_hex(floor(extract(epoch FROM clock_timestamp()) * 1000)::bigint), 12, '0') || encode(gen_random_bytes(10), 'hex'))::uuid;
$$ LANGUAGE SQL;
;

-- Create tables section -------------------------------------------------

-- Table fornecedor

CREATE TABLE "fornecedor"
(
 	"id_fornecedor" UUID NOT NULL,
  	"ds_fornecedor" Character varying(45) NOT NULL
)
WITH (
  autovacuum_enabled=true)
;
COMMENT ON TABLE "fornecedor" IS 'Fornecedores'
;
COMMENT ON COLUMN "fornecedor"."id_fornecedor" IS 'ID'
;
COMMENT ON COLUMN "fornecedor"."ds_fornecedor" IS 'Descrição'
;

ALTER TABLE "fornecedor" ADD CONSTRAINT "pk_fornecedor" PRIMARY KEY ("id_fornecedor")
;

-- Table produto

CREATE TABLE "produto"
(
  	"id_produto" UUID NOT NULL,
	"id_fornecedor" UUID NOT NULL,
	"ds_produto" Character varying(80) NOT NULL,
	"nr_valor" Numeric(18,2) NOT NULL,
	"nr_quantidade" Integer NOT NULL
)
WITH (
  autovacuum_enabled=true)
;
COMMENT ON TABLE "produto" IS 'Produto'
;
COMMENT ON COLUMN "produto"."id_produto" IS 'ID'
;
COMMENT ON COLUMN "produto"."id_fornecedor" IS 'Fornecedor'
;
COMMENT ON COLUMN "produto"."ds_produto" IS 'Descrição técnica'
;
COMMENT ON COLUMN "produto"."nr_valor" IS 'Valor'
;
COMMENT ON COLUMN "produto"."nr_quantidade" IS 'Quantidade'
;

ALTER TABLE "produto" ADD CONSTRAINT "pk_produto" PRIMARY KEY ("id_produto")
;

-- Table item

CREATE TABLE "item"
(
  	"id_item" UUID NOT NULL,
	"id_produto" UUID NOT NULL,
	"id_venda" UUID NOT NULL,
	"nr_quantidade" Integer NOT NULL,
	"nr_valorparcial" Numeric(18,2) NOT NULL
)
WITH (
  autovacuum_enabled=true)
;
COMMENT ON TABLE "item" IS 'Item'
;
COMMENT ON COLUMN "item"."id_item" IS 'ID'
;
COMMENT ON COLUMN "item"."id_produto" IS 'Produto'
;
COMMENT ON COLUMN "item"."id_venda" IS 'Venda'
;
COMMENT ON COLUMN "item"."nr_quantidade" IS 'Quantidade'
;
COMMENT ON COLUMN "item"."nr_valorparcial" IS 'Valor parcial'
;

ALTER TABLE "item" ADD CONSTRAINT "pk_item" PRIMARY KEY ("id_item")
;

-- Table venda

CREATE TABLE "venda"
(
	"id_venda" UUID NOT NULL,
	"id_funcionario" UUID NOT NULL,
	"dt_venda" Timestamp(0) with time zone NOT NULL,
	"nr_valortotal" Numeric(18,2) NOT NULL
)
WITH (
  autovacuum_enabled=true)
;
COMMENT ON TABLE "venda" IS 'Venda'
;
COMMENT ON COLUMN "venda"."id_venda" IS 'ID'
;
COMMENT ON COLUMN "venda"."id_funcionario" IS 'Funcionário'
;
COMMENT ON COLUMN "venda"."dt_venda" IS 'Data de venda'
;
COMMENT ON COLUMN "venda"."nr_valortotal" IS 'Valor total'
;

ALTER TABLE "venda" ADD CONSTRAINT "pk_venda" PRIMARY KEY ("id_venda")
;

-- Table funcionario

CREATE TABLE "funcionario"
(
	"id_funcionario" UUID NOT NULL,
	"nm_funcionario" Character varying(45) NOT NULL,
	"nr_documento" Character varying(20) NOT NULL,
	"ds_senha" Character varying(50) NOT NULL,
	"ds_funcao" Character varying(50) NOT NULL
)
WITH (
  autovacuum_enabled=true)
;
COMMENT ON TABLE "funcionario" IS 'Funcionário'
;
COMMENT ON COLUMN "funcionario"."id_funcionario" IS 'ID'
;
COMMENT ON COLUMN "funcionario"."nm_funcionario" IS 'Nome'
;
COMMENT ON COLUMN "funcionario"."nr_documento" IS 'Cpf'
;
COMMENT ON COLUMN "funcionario"."ds_senha" IS 'Senha'
;
COMMENT ON COLUMN "funcionario"."ds_funcao" IS 'Função'
;

ALTER TABLE "funcionario" ADD CONSTRAINT "pk_funcionario" PRIMARY KEY ("id_funcionario")
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE "produto"
  ADD CONSTRAINT "rel_fornecedor_produto"
    FOREIGN KEY ("id_fornecedor")
    REFERENCES "fornecedor" ("id_fornecedor")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "item"
  ADD CONSTRAINT "rel_produto_item"
    FOREIGN KEY ("id_produto")
    REFERENCES "produto" ("id_produto")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "item"
  ADD CONSTRAINT "rel_venda_item"
    FOREIGN KEY ("id_venda")
    REFERENCES "venda" ("id_venda")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "venda"
  ADD CONSTRAINT "rel_funcionario_venda"
    FOREIGN KEY ("id_funcionario")
    REFERENCES "funcionario" ("id_funcionario")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;