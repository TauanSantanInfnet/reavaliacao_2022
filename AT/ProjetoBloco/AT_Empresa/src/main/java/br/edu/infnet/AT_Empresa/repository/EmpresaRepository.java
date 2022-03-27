package br.edu.infnet.AT_Empresa.repository;

import br.edu.infnet.AT_Empresa.domain.Empresa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {
    @Query("from Empresa p where p.id = :id")
    public Empresa findFirstById(Integer id);
}
