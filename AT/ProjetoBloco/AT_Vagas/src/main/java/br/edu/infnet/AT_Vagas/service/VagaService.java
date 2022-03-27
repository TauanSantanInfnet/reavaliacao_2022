package br.edu.infnet.AT_Vagas.service;

import br.edu.infnet.AT_Vagas.domain.Vaga;
import br.edu.infnet.AT_Vagas.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {
    @Autowired
    private VagaRepository vagaRepository;

    public void deleteById(Integer id) { vagaRepository.deleteById(id);}

    public Vaga findById(Integer id){
        return (Vaga) vagaRepository.findFirstById(id);
    }

    public List<Vaga> getAll() { return vagaRepository.getAll();}
    public Vaga Cadastrar(Vaga usuario) {
        vagaRepository.save(usuario);
        return usuario;
    }

    public void update(Vaga vaga)
    {
        var vagaDb = vagaRepository.findFirstById(vaga.getId());
        if(vagaDb != null)
        {
            vagaDb.setVagaSituacao(vaga.getVagaSituacao());
            vagaDb.setDescricao(vaga.getDescricao());
            vagaDb.setDataFinal(vaga.getDataFinal());
            vagaRepository.save(vagaDb);
        }
    }
}
