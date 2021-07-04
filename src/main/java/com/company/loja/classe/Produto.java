package com.company.loja.classe;


import com.company.loja.dto.ProdutoDto;

import java.util.Objects;

public class Produto {

    private long id;
    private String codigo;
    private String descricao;
    private int quantidade;
    private double preco;

    public Produto(ProdutoDto p) {
        this.codigo = p.getCodigo();
        this.descricao = p.getDescricao();
        this.quantidade = p.getQuantidade();
        this.preco = p.getPreco();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean equalsDto(Object o){
        ProdutoDto produto = (ProdutoDto) o;
        return this.codigo.equals(produto.getCodigo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

