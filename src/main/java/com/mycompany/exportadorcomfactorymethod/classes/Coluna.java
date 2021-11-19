package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;

public interface Coluna {
    String getTitulo();
    void setTitulo(String titulo);
    String abrir();
    String fechar();
    String exportarCabecalho();
    String exportarDado(Produto produto);
}
