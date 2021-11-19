package com.mycompany.exportadorcomfactorymethod.classes;

import com.mycompany.exportadorcomfactorymethod.entity.Produto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractExportadorListaProduto implements ExportadorListaProduto {

    protected List<Coluna> getColunas() {
        return colunas;
    }

    protected static final List<String> TITULOS_COLUNAS = Arrays.asList("ID", "Descrição", "Marca", "Modelo", "Estoque");
    private List<Coluna> colunas;

    public AbstractExportadorListaProduto() {
        colunas = new ArrayList<>();
        colunas.add(newColuna(Produto::getId, "Código"));
        colunas.add(newColuna(Produto::getDescricao, "Descrição"));
        colunas.add(newColuna(Produto::getMarca, "Marca"));
        colunas.add(newColuna(Produto::getModelo, "Modelo"));
        colunas.add(newColuna(Produto::getEstoque, "Estoque"));
    }

    @Override
    public void addColuna(Coluna coluna){
        getColunas().add(coluna);
    }

    @Override
    public final String exportar(List<Produto> listaProdutos) {
        final StringBuilder sb = new StringBuilder();
        sb.append(abrirTabela());

        for(Coluna coluna : getColunas()){
            sb.append(coluna.exportarCabecalho());
        }
        //sb.append(fecharLinha());
        sb.append("\n");
        sb.append(fecharLinhaTitulos());
        gerarLinhasProdutos(sb, listaProdutos);

        sb.append(fecharTabela());
        return sb.toString();
    }
    private void gerarLinhasProdutos(StringBuilder sb, List<Produto> listaProdutos) {
        for (Produto produto : listaProdutos) {
            sb.append(gerarColunasLinha(produto));
        }         
    }

    protected String gerarColunasLinha(Produto produto) {
        StringBuilder sb = new StringBuilder();
        sb.append(abrirLinha());
        for (Coluna coluna : getColunas()) {
            sb.append(coluna.exportarDado(produto));
        }
        sb.append(fecharLinha());
        return sb.toString();
    }
}