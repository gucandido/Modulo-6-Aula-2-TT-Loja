package com.company.loja;

import com.company.loja.classe.Cliente;
import com.company.loja.classe.Pedido;
import com.company.loja.classe.Produto;
import com.company.loja.dao.ClienteDao;
import com.company.loja.dao.PedidoDao;
import com.company.loja.dao.ProdutoDao;
import com.company.loja.dto.ClienteDto;
import com.company.loja.dto.PedidoDto;
import com.company.loja.dto.ProdutoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LojaApplication {

    public static List<Produto> staticProdutos = new ArrayList<>();
    public static List<Pedido> staticPedidos = new ArrayList<>();
    public static List<Cliente> staticClientes = new ArrayList<>();

    public static void main(String[] args) {

        SpringApplication.run(LojaApplication.class, args);

        List<ProdutoDto> pedido1 = new ArrayList<>();
        List<ProdutoDto> pedido2 = new ArrayList<>();
        List<ProdutoDto> pedido3 = new ArrayList<>();

        // produtos da loja
        ProdutoDto p1 = new ProdutoDto("XYZ0000","Coxinha Iphome (frango)",3,2.50);
        ProdutoDto p2 = new ProdutoDto("XYZ0001", "Polystation 4 Pro (24fps)", 1, 356.99);
        ProdutoDto p3 = new ProdutoDto("XYZ0002","Os 50 contos de Assado de Machis", 5,48.90);
        ProdutoDto p4 = new ProdutoDto("XYZ0003","Biografia de Cristonaldo Roniano", 3, 11.50);

        ProdutoDao.save(p1);
        ProdutoDao.save(p2);
        ProdutoDao.save(p3);
        ProdutoDao.save(p4);

        pedido1.add(p1);
        pedido1.add(p3);

        pedido2.add(p1);
        pedido2.add(p2);
        pedido2.add(p4);

        pedido3.add(p2);

        // pedidos por cliente
        PedidoDao.save(new PedidoDto(pedido1));
        PedidoDao.save(new PedidoDto(pedido2));
        PedidoDao.save(new PedidoDto(pedido3));

        // clientes
        List<PedidoDto> ls = new ArrayList<>();
        ls.add(PedidoDto.class2dto(PedidoDao.readById(0)));
        ClienteDao.save(new ClienteDto("gustavo mais ou menos de souza","00001","123@gmail.com","0800-12-1520",ls));

        ls = new ArrayList<>();
        ls.add(PedidoDto.class2dto(PedidoDao.readById(1)));
        ClienteDao.save(new ClienteDto("creiton mais ou menos de souza","00002","133@gmail.com","0800-12-1521",ls));

        ls = new ArrayList<>();
        ls.add(PedidoDto.class2dto(PedidoDao.readById(2)));
        ClienteDao.save(new ClienteDto("jandira mais ou menos de souza","00003","124@gmail.com","0800-12-1523",ls));

        ls = null;
    }

}
