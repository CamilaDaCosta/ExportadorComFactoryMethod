package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;
import java.util.function.Function;

public class ExportadorListaProdutoCsv extends AbstractExportadorListaProduto{
 @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "\n";
    }

    @Override
    public String abrirLinha() {
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    public Coluna newColuna(Function<Produto, Object> obterValorColuna, String titulo) {
        return new ColunaCsv(obterValorColuna, titulo);
    }
}
