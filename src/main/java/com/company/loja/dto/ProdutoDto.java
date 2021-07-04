package com.company.loja.dto;

import com.company.loja.classe.Produto;

public class ProdutoDto {

    private String codigo;
    private String descricao;
    private int quantidade;
    private double preco;

    public ProdutoDto(String codigo, String descricao, int quantidade, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public ProdutoDto(Produto p) {
        this.codigo = p.getCodigo();
        this.descricao = p.getDescricao();
        this.quantidade = p.getQuantidade();
        this.preco = p.getPreco();
    }

    public ProdutoDto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static Produto Dto2class(ProdutoDto p){
        return new Produto(p);
    }

    public static ProdutoDto class2dto(Produto p){
        return new ProdutoDto(p);
    }

}
