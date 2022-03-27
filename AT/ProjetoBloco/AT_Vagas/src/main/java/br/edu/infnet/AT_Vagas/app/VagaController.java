package br.edu.infnet.AT_Vagas.app;

import br.edu.infnet.AT_Vagas.domain.Vaga;
import br.edu.infnet.AT_Vagas.model.VagaModel;
import br.edu.infnet.AT_Vagas.service.VagaService;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VagaController {
    @Autowired
    private VagaService vagaService;

    @GetMapping(value="/vaga/{id}")
    public ResponseEntity<Vaga> findById(@PathVariable Integer id)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(id == null || id == 0){
            return retorno;
        }

        var vaga = vagaService.findById(id);
        return ResponseEntity.ok().body(vaga);
    }

    @RequestMapping(value="/vaga/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Vaga> deleteById(@PathVariable Integer id)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(id == null || id == 0){
            return retorno;
        }

        vagaService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/vaga/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vaga>> getAll()
    {
        var retorno = vagaService.getAll();
        return new ResponseEntity<List<Vaga>>(retorno, HttpStatus.OK);
    }

    @RequestMapping(value="/vaga/",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity incluir(@RequestBody VagaModel model)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(model.getDescricao().equals("") || model.getDataCadastro().equals("") || model.getEmpresaId().equals("")
            || model.getRequisitos().equals("")){
            return retorno;
        }

        Vaga vaga = new Vaga();
        vaga.setDataCadastro(model.getDataCadastro());
        vaga.setDescricao(model.getDescricao());
        vaga.setEmpresaId(model.getEmpresaId());
        vaga.setVagaSituacao(model.getVagaSituacao());
        vaga.setRequisitos(model.getRequisitos());
        vagaService.Cadastrar(vaga);

        return ResponseEntity.ok().body(vaga);
    }

    @RequestMapping(value="/vaga/",method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    public ResponseEntity update(@RequestBody VagaModel model)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(model.getDescricao().equals("") || model.getDataCadastro().equals("") || model.getEmpresaId().equals("")
                || model.getRequisitos().equals("") || model.getId().equals("")){
            return retorno;
        }

        Vaga vaga = new Vaga();
        vaga.setDataCadastro(model.getDataCadastro());
        vaga.setDescricao(model.getDescricao());
        vaga.setEmpresaId(model.getEmpresaId());
        vaga.setVagaSituacao(model.getVagaSituacao());
        vaga.setRequisitos(model.getRequisitos());
        vaga.setId(model.getId());
        vagaService.update(vaga);

        return ResponseEntity.ok().body(vaga);
    }

    @DeleteMapping(value="/Vaga/{id}")
    public ResponseEntity Excluir(@PathVariable Integer id)
    {
        vagaService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
