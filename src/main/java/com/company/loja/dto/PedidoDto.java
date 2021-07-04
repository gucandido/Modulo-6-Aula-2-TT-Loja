package com.company.loja.dto;

import com.company.loja.classe.Pedido;
import com.company.loja.classe.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PedidoDto {

    @JsonIgnore private long id;
    private List<ProdutoDto> produtos = new ArrayList<>();
    private double precoTotal;

    public PedidoDto(Pedido p) {
        this.id = p.getId();
        p.getProdutos().forEach(x->this.produtos.add(ProdutoDto.class2dto(x)));
        this.precoTotal = p.getPrecoTotal();
    }

    public PedidoDto(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoDto pedidoDto = (PedidoDto) o;
        return id == pedidoDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Pedido dto2class(PedidoDto p){
        return new Pedido(p);
    }

    public static PedidoDto class2dto(Pedido p){
        return new PedidoDto(p);
    }
}
