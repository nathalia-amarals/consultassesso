package com.indtexbr.consultoriasassessorias.repository;

import com.indtexbr.consultoriasassessorias.entity.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
//@RepositoryRestResource(itemResourceRel = "contrato", path = "contrato")
public interface ContratoRepository extends MongoRepository<Contrato, Long> {
}
