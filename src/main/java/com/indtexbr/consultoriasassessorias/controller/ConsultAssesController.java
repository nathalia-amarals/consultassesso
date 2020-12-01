package com.indtexbr.consultoriasassessorias.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.indtexbr.consultoriasassessorias.entity.Contrato;
import com.indtexbr.consultoriasassessorias.repository.ContratoRepository;
//import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/consultassesso")
public class ConsultAssesController {

    @Autowired
    private ContratoRepository contratoRepository;

    @GetMapping
    public ResponseEntity<List<Contrato>> consultaContratos()
    {
        return new ResponseEntity<List<Contrato>>(contratoRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> consultaContrato(@PathVariable("id")BigInteger id){
        Optional<Contrato> contratoOptional = contratoRepository.findById(id);
        return new ResponseEntity<Contrato>(contratoOptional.orElseGet(null),HttpStatus.OK);
    }

//    @GetMapping("/descricao")
//    public Contrato consultaContratoporDesc(@RequestParam("descricao") String descricao){
//        Contrato contrato = new Contrato();
//        contrato.setDescricao(descricao);
//        Example <Contrato> example = Example.of(contrato);
//        return contratoRepository.findOne(example).get();
//    }

    @PostMapping
    public ResponseEntity<Contrato> criaContrato(@RequestBody Contrato contrato){
        if(contrato != null && contrato.getId() != null)
        {
            contratoRepository.save(contrato);
            return new ResponseEntity<Contrato>(contrato,HttpStatus.CREATED);
        }

        return new ResponseEntity<Contrato>(contrato,HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Contrato> atualizaContrato(@RequestBody Contrato contrato){
        if(contrato.getId()!=null)
        {
            Contrato contratoUpdate = contratoRepository.findById(contrato.getId()).get();
            if(contrato.getIdEmpresa() != null)
                contratoUpdate.setIdEmpresa(contrato.getIdEmpresa());
            if(contrato.getValor() != null)
                contratoUpdate.setValor(contrato.getValor());
            if(contrato.getDescricao() != null)
                contratoUpdate.setDescricao(contrato.getDescricao());
            return new ResponseEntity<Contrato>(contratoRepository.save(contratoUpdate), HttpStatus.OK);
        }

        return new ResponseEntity<Contrato>(contrato,HttpStatus.BAD_REQUEST);
    }
}
