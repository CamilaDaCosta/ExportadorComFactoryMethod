package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;
import java.util.function.Function;

public class ExportadorListaProdutoHtml extends AbstractExportadorListaProduto{
 @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>\n";
    }

    @Override
    public String abrirLinha() {
        return "  <tr>";
    }

    @Override
    public String fecharLinha() {
        return "</tr>\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "";
    }

    @Override
    public Coluna newColuna(Function<Produto, Object> obterValorColuna, String titulo) {
        return new ColunaHtml(obterValorColuna, titulo);
    }
}
