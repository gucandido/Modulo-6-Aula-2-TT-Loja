package com.company.loja;

import com.company.loja.dao.ClienteDao;
import com.company.loja.dto.ClienteDto;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loja")
public class LojaController {

    @GetMapping("/cliente")
    public ResponseEntity<?> getPedidoCliente(){

        List<ClienteDto> retorno = new ArrayList<>();

        ClienteDao.readAll().forEach(x->retorno.add(ClienteDto.class2dto(x)));

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<?> getPedidoCliente(@PathVariable String cpf){

        return new ResponseEntity<>(ClienteDto.class2dto(ClienteDao.readByCpf(cpf)), HttpStatus.OK);
    }

}
