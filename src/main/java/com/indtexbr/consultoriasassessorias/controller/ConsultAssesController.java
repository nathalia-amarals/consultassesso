package com.indtexbr.consultoriasassessorias.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.indtexbr.consultoriasassessorias.entity.Contrato;
import com.indtexbr.consultoriasassessorias.entity.Empresa;
import com.indtexbr.consultoriasassessorias.repository.ContratoRepository;
//import org.hibernate.criterion.Example;
import com.indtexbr.consultoriasassessorias.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/consultassesso")
public class ConsultAssesController {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("contrato")
    public ResponseEntity<List<Contrato>> consultaContratos()
    {
        return new ResponseEntity<List<Contrato>>(contratoRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping("contrato/{id}")
    public ResponseEntity<Contrato> consultaContrato(@PathVariable Long id){
        Optional<Contrato> contratoOptional = contratoRepository.findById(id);
        return new ResponseEntity<Contrato>(contratoOptional.orElseGet(null),HttpStatus.OK);
    }

    @PostMapping("contrato")
    public ResponseEntity<Contrato> criaContrato(@RequestBody Contrato contrato){
        if(contrato != null && contrato.getId() != null)
        {
            contratoRepository.save(contrato);
            return new ResponseEntity<Contrato>(contrato,HttpStatus.CREATED);
        }

        return new ResponseEntity<Contrato>(contrato,HttpStatus.BAD_REQUEST);
    }

    @PutMapping("contrato")
    public ResponseEntity<Contrato> atualizaContrato(@RequestBody Contrato contrato){


        Optional<Contrato> contratoCadastrado = contratoRepository.findById(contrato.getId());

        if(!contratoCadastrado.isEmpty())
        {
            if(contrato.getDescricao() == null)
            {
                contrato.setDescricao(contratoCadastrado.get().getDescricao());
            }
            if(contrato.getIdEmpresa() == null)
            {
                contrato.setIdEmpresa(contratoCadastrado.get().getIdEmpresa());
            }
            if(contrato.getValor() == null)
            {
                contrato.setValor(contratoCadastrado.get().getValor());
            }

            return new ResponseEntity<Contrato>(contratoRepository.save(contrato), HttpStatus.OK);
        }

        return new ResponseEntity<Contrato>(contrato,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("contrato/{id}")
    public ResponseEntity deletaContrato(@PathVariable Long id){
        boolean contratoCadastrado = contratoRepository.findById(id) != null ? true : false;
        if(id != null && contratoCadastrado)
        {
            contratoRepository.deleteById(id);
            return new ResponseEntity("Contrato " + id + " Deletada",HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("empresa")
    public ResponseEntity criaEmpresa(@RequestBody Empresa empresa){
        if(empresa != null && empresa.getId() != null)
        {
            empresaRepository.save(empresa);
            return new ResponseEntity(empresa.toString(),HttpStatus.CREATED);
        }

        return new ResponseEntity(empresa.toString(),HttpStatus.BAD_REQUEST);
    }

    @PutMapping("empresa")
    public ResponseEntity atualizaEmpresa(@RequestBody Empresa empresa){
        //Empresa empresaCadastrada = empresaRepository.findByRazaoSocial(empresa.getRazaoSocial());
        Optional<Empresa> empresaCadastrada = empresaRepository.findById(empresa.getId());
        if(!empresaCadastrada.isEmpty())
        {
            if(empresa.getAreaDeAtuacao().equals(""))
            {
                empresa.setAreaDeAtuacao(empresaCadastrada.get().getAreaDeAtuacao());
            }
            if(empresa.getCNPJ().equals(""))
            {
                empresa.setCNPJ(empresaCadastrada.get().getCNPJ());
            }
            if(empresa.getRazaoSocial().equals(""))
            {
                empresa.setRazaoSocial(empresaCadastrada.get().getRazaoSocial());
            }

            empresaRepository.save(empresa);
            return new ResponseEntity(empresa.toString(),HttpStatus.CREATED);
        }

        return new ResponseEntity(empresa.toString(),HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("empresa/{id}")
    public ResponseEntity deletaEmpresa(@PathVariable Long id){
        boolean empresaCadastrada = empresaRepository.findById(id) != null ? true : false;
        if(id != null && empresaCadastrada)
        {
            empresaRepository.deleteById(id);
            return new ResponseEntity("Empresa " + id + " Deletada",HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
