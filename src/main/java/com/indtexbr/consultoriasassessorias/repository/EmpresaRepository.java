package com.indtexbr.consultoriasassessorias.repository;

import com.indtexbr.consultoriasassessorias.entity.Contrato;
import com.indtexbr.consultoriasassessorias.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(itemResourceRel = "empresa", path = "empresa")
public interface EmpresaRepository extends MongoRepository<Empresa,Long> {
    @Query("select * from Empresa where razaoSocial = :razaoSocial")
    public Empresa findByRazaoSocial(String razaoSocial);
}
