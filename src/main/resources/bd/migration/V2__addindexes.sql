CREATE INDEX "idx_produto_idfornecedor" ON "produto" ("id_fornecedor")
;

CREATE INDEX "idx_item_idproduto" ON "item" ("id_produto")
;

CREATE INDEX "idx_item_idvenda" ON "item" ("id_venda")
;

CREATE INDEX "idx_venda_idfuncionario" ON "venda" ("id_funcionario")
;
