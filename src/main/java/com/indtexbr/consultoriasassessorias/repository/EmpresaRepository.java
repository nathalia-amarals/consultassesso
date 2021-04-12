package com.indtexbr.consultoriasassessorias.repository;

import com.indtexbr.consultoriasassessorias.entity.Empresa;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;

//@Repository
//@RepositoryRestResource(itemResourceRel = "empresa", path = "empresa")
public interface EmpresaRepository extends MongoRepository<Empresa,Long> {
    public Empresa findByRazaoSocial(String razaoSocial);
}
