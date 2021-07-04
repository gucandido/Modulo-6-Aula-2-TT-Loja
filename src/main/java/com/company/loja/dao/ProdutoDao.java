package com.company.loja.dao;

import com.company.loja.classe.Produto;
import com.company.loja.dto.ProdutoDto;

import java.util.List;

import static com.company.loja.LojaApplication.staticProdutos;

public class ProdutoDao {

    public static Produto save(ProdutoDto p){

        long id;

        if(!staticProdutos.isEmpty()){
            id = staticProdutos.stream().max((o1, o2) -> Long.compare(o1.getId(),o2.getId())).get().getId()+1;
        }else{
            id = 0L;
        }

        Produto produto = new Produto(p);
        produto.setId(id);

        staticProdutos.add(produto);

        return produto;

    }

    public static Produto readById(long id){

        return staticProdutos.stream().filter(x->x.getId() == id).findFirst().get();

    }

    public static List<Produto> readAll(){
        return staticProdutos;
    }

    public static Produto update(ProdutoDto newProduto){

        Produto p = staticProdutos.stream().filter(x-> x.equalsDto(newProduto)).findFirst().get();

        p.setCodigo(newProduto.getCodigo());
        p.setDescricao(newProduto.getDescricao());
        p.setPreco(newProduto.getPreco());
        p.setQuantidade(newProduto.getQuantidade());

        System.out.println(staticProdutos.stream().filter(x-> x.equalsDto(newProduto)).findFirst().get().toString());

        return p;

    }

    public static void delete(String codigo){

        staticProdutos.removeIf(p->p.getCodigo().equals(codigo));

    }

}
