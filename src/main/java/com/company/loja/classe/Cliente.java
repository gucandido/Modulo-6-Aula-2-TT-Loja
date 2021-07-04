package com.company.loja.classe;

import com.company.loja.dto.ClienteDto;
import com.company.loja.dto.PedidoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(ClienteDto c) {
        this.nome = c.getNome();
        this.cpf = c.getCpf();
        this.email = c.getEmail();
        this.telefone = c.getTelefone();
        c.getPedidos().forEach(x->this.pedidos.add(PedidoDto.dto2class(x)));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public boolean equalsDto(Object o){
        ClienteDto cliente = (ClienteDto) o;
        return cpf.equals(cliente.getCpf());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
