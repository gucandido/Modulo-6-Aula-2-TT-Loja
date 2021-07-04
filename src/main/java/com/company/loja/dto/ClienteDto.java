package com.company.loja.dto;

import com.company.loja.classe.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<PedidoDto> pedidos = new ArrayList<>();

    public ClienteDto(String nome, String cpf, String email, String telefone, List<PedidoDto> pedidos) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = pedidos;
    }

    public ClienteDto(Cliente c) {
        this.nome = c.getNome();
        this.cpf = c.getCpf();
        this.email = c.getEmail();
        this.telefone = c.getTelefone();

        c.getPedidos().forEach(x->this.pedidos.add(PedidoDto.class2dto(x)));
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

    public List<PedidoDto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDto> pedidos) {
        this.pedidos = pedidos;
    }

    public static ClienteDto class2dto(Cliente c){
        return new ClienteDto(c);
    }

}
