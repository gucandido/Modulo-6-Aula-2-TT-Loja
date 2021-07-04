package com.company.loja.dao;

import com.company.loja.classe.Cliente;
import com.company.loja.classe.Pedido;
import com.company.loja.classe.Produto;
import com.company.loja.dto.ClienteDto;
import com.company.loja.dto.PedidoDto;
import com.company.loja.dto.ProdutoDto;

import java.util.ArrayList;
import java.util.List;

import static com.company.loja.LojaApplication.staticClientes;

public class ClienteDao {

    public static Cliente save(ClienteDto c){

        long id;

        if(!staticClientes.isEmpty()){
            id = staticClientes.stream().max((o1, o2) -> Long.compare(o1.getId(),o2.getId())).get().getId()+1;
        }else{
            id = 0L;
        }

        Cliente cliente = new Cliente(c);
        cliente.setId(id);

        staticClientes.add(cliente);

        return cliente;

    }

    public static Cliente readById(long id){

        return staticClientes.stream().filter(x->x.getId() == id).findFirst().get();

    }

    public static Cliente readByCpf(String cpf){

        return staticClientes.stream().filter(x->x.getCpf().equals(cpf)).findFirst().get();

    }

    public static List<Cliente> readAll(){
        return staticClientes;
    }

    public static Cliente update(ClienteDto newCliente){

        Cliente c = staticClientes.stream().filter(x-> x.equalsDto(newCliente)).findFirst().get();

        c.setNome(newCliente.getNome());
        c.setCpf(newCliente.getCpf());
        c.setEmail(newCliente.getEmail());
        c.setTelefone(newCliente.getTelefone());

        List<Pedido> pedidos = new ArrayList<>();
        newCliente.getPedidos().forEach(x->pedidos.add(PedidoDto.dto2class(x)));
        c.setPedidos(pedidos);

        System.out.println(staticClientes.stream().filter(x-> x.equalsDto(newCliente)).findFirst().get().toString());

        return c;

    }

    public static void delete(String cpf){

        staticClientes.removeIf(p->p.getCpf().equals(cpf));

    }

}
