package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;
import java.util.function.Function;

class ColunaHtml extends AbstractColuna {

    public ColunaHtml(Function<Produto, Object> obterValorColuna, String titulo) {
        super(obterValorColuna, titulo);
    }

    @Override
    public String abrir() {
        return "<td>";
    }

    @Override
    public String fechar() {
        return "</td>";
    }
    
}
