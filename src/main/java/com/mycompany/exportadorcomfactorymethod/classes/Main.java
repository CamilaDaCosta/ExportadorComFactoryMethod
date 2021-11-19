package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("TV", "LG", "132-A", 120));
        produtos.add(new Produto("Notebook", "Asus", "New age", 341));
        produtos.add(new Produto("Smartphone", "Samsung", "Galaxy S10", 214));

        ExportadorListaProduto exportadorPadrao = ExportadorListaProduto.newInstance();
        System.out.println("Lista de Produtos em HTML\n");
        System.out.println(exportadorPadrao.exportar(produtos));

        ExportadorListaProduto exportadorMarkdown = ExportadorListaProduto.newInstance("md");
        System.out.println("Lista de Produtos em Markdown\n");
        System.out.println(exportadorMarkdown.exportar(produtos));
        
         ExportadorListaProduto exportadorCsv = ExportadorListaProduto.newInstance("csv");
        System.out.println("Lista de Produtos CSV\n");
        System.out.println(exportadorCsv.exportar(produtos));
    }
}
