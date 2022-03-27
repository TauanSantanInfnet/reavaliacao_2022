package br.edu.infnet.AT_Empresa.app;

import br.edu.infnet.AT_Empresa.domain.Empresa;
import br.edu.infnet.AT_Empresa.model.EmpresaModel;
import br.edu.infnet.AT_Empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmpresaController  {
    @Autowired
    private EmpresaService empresaService;

    @GetMapping(value="/empresa/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable Integer id)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(id == null || id == 0){
            return retorno;
        }

        var empresa = empresaService.findById(id);
        return ResponseEntity.ok().body(empresa);
    }

        @RequestMapping(value="/empresa/",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity incluir(@RequestBody EmpresaModel model)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(model.getEndereco().equals("") || model.getRazaoSocial().equals("")){
            return retorno;
        }

        var empresa = new Empresa();
        empresa.setEndereco(model.getEndereco());
        empresa.setRazaoSocial(model.getRazaoSocial());
        empresaService.Cadastrar(empresa);

        return ResponseEntity.ok().body(empresa);
    }
}
