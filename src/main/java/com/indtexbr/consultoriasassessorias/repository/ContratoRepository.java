package com.indtexbr.consultoriasassessorias.repository;

import com.indtexbr.consultoriasassessorias.entity.Contrato;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;

//@Repository
//@RepositoryRestResource(itemResourceRel = "contrato", path = "contrato")
public interface ContratoRepository extends MongoRepository<Contrato, Long> {
}
