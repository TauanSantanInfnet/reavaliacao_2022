package br.edu.infnet.AT_Vagas.repository;

import br.edu.infnet.AT_Vagas.domain.Vaga;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VagaRepository extends CrudRepository<Vaga, Integer> {
    @Query("from Vaga p where p.id = :id")
    public Vaga findFirstById(Integer id);

    @Query("from Vaga p")
    public List<Vaga> getAll();

    @Transactional
    @Modifying
    @Query("delete from Vaga p where p.id = :id")
    public void deleteById(Integer id);

}
