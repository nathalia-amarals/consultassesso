package com.indtexbr.consultoriasassessorias.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.indtexbr.consultoriasassessorias.entity.Contrato;
import com.indtexbr.consultoriasassessorias.repository.ContratoRepository;
//import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class ConsultAssesController {

    @Autowired
    private ContratoRepository contratoRepository;

    @GetMapping
    public List<Contrato> consultaContratos(){
        return contratoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contrato consultaContrato(@PathVariable("id")BigInteger id){
        return contratoRepository.findById(id).get();
    }

    @GetMapping("/descricao")
    public Contrato consultaContratoporDesc(@RequestParam("descricao") String descricao){
        Contrato contrato = new Contrato();
        contrato.setDescricao(descricao);
        Example <Contrato> example = Example.of(contrato);
        return contratoRepository.findOne(example).get();
    }
}
