package com.company.loja.classe;

import com.company.loja.dto.PedidoDto;
import com.company.loja.dto.ProdutoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private long id;
    private List<Produto> produtos = new ArrayList<>();
    private double precoTotal;

    public Pedido(PedidoDto p) {
        p.getProdutos().forEach(x->this.produtos.add(ProdutoDto.Dto2class(x)));
        this.precoTotal = calcTotal();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public double calcTotal(){

        return this.produtos.stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();

    }

    public boolean equalsDto(Object o){
        PedidoDto pedidoDto = (PedidoDto) o;
        return id == pedidoDto.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
