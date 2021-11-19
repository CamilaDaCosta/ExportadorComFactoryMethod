package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class ExportadorListaProdutoMarkdown extends AbstractExportadorListaProduto {
    private static final String SEPARADOR_LN = "-";
    private static final String SEPARADOR_COL = "|";

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
        StringBuilder sb = new StringBuilder();
        for(Coluna coluna : getColunas()){
            sb.append(coluna.abrir()+ "-----");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public Coluna newColuna(Function<Produto, Object> obterValorColuna, String titulo) {
        return new ColunaMd(obterValorColuna,titulo);
    }
}
