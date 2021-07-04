package com.company.loja.dao;

import com.company.loja.classe.Pedido;
import com.company.loja.classe.Produto;
import com.company.loja.dto.PedidoDto;
import com.company.loja.dto.ProdutoDto;

import java.util.ArrayList;
import java.util.List;

import static com.company.loja.LojaApplication.staticPedidos;

public class PedidoDao {

    public static Pedido save(PedidoDto p){

        long id;

        if(!staticPedidos.isEmpty()){
            id = staticPedidos.stream().max((o1, o2) -> Long.compare(o1.getId(),o2.getId())).get().getId()+1;
        }else{
            id = 0L;
        }

        Pedido pedido = new Pedido(p);
        pedido.setId(id);

        staticPedidos.add(pedido);

        return pedido;

    }

    public static Pedido readById(long id){

        return staticPedidos.stream().filter(x->x.getId() == id).findFirst().get();

    }

    public static List<Pedido> readAll(){
        return staticPedidos;
    }

    public static Pedido update(PedidoDto newPedido){

        Pedido p = staticPedidos.stream().filter(x-> x.equalsDto(newPedido)).findFirst().get();

        p.setId(newPedido.getId());

        List<Produto> newProds = new ArrayList<>();
        newPedido.getProdutos().forEach(x->newProds.add(ProdutoDto.Dto2class(x)));
        p.setProdutos(newProds);
        p.setPrecoTotal(p.calcTotal());

        System.out.println(staticPedidos.stream().filter(x-> x.equalsDto(newPedido)).findFirst().get().toString());

        return p;

    }

    public static void delete(long id){

        staticPedidos.removeIf(p->p.getId() == id);

    }

}
