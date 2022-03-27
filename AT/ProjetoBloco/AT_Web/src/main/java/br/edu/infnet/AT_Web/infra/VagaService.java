package br.edu.infnet.AT_Web.infra;

import br.edu.infnet.AT_Web.domain.Usuario;
import br.edu.infnet.AT_Web.domain.Vaga;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VagaService {
    public List<Vaga> getAll() {
        var retorno = Unirest.get("http://localhost:8081/vaga/")
                .header("Content-Type", "application/json")
                .asObject(new GenericType<List<Vaga>>(){})
                .getBody();


       return retorno;
    }

    public Vaga cadastrar(Vaga vaga) {
        vaga.setVagaSituacao("A");
        vaga.setDataCadastro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));

        var retorno = Unirest.post("http://localhost:8081/vaga/")
                .header("Content-Type", "application/json")
                .body(vaga)
                .asObject(Vaga.class);

        if(retorno.getStatus() != 200){
            return null;
        }
        else{
            return retorno.getBody();
        }
    }
    public void deleteById(Integer id) {
        var retorno = Unirest.delete("http://localhost:8081/vaga/" + id)
                .header("Content-Type", "application/json")
                .asEmpty();
    }
}
