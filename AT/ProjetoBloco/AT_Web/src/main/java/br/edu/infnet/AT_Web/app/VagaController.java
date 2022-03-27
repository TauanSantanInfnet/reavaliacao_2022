package br.edu.infnet.AT_Web.app;

import br.edu.infnet.AT_Web.domain.Usuario;
import br.edu.infnet.AT_Web.domain.Vaga;
import br.edu.infnet.AT_Web.infra.UsuarioService;
import br.edu.infnet.AT_Web.infra.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class VagaController {
    @Autowired
    VagaService vagaService;

    @GetMapping(value="/Vaga")
    public String home(Model model)
    {
        var vagas = vagaService.getAll();
        model.addAttribute("lista",vagas);
        return "Vaga/HomeVaga";
    }

    @GetMapping(value="/Vaga/Cadastrar")
    public String cadastrar(Model model)
    {
        return "Vaga/Cadastrar";
    }

    @PostMapping(value="/Vaga")
    public String login(Model model, Vaga vaga)
    {
        vaga.setEmpresaId(1);
        var vagaDb = vagaService.cadastrar(vaga);

        if(vagaDb == null){
            model.addAttribute("mensagem", "Erro ao cadastrar vaga. Verifique os dados informados");
            return cadastrar(model);
        }else{
            model.addAttribute("mensagem","Usuário incluído com sucesso");
            return home(model);
        }
    }

    @GetMapping(value="/Vaga/{id}/excluir")
    public String Excluir(Model model, @PathVariable Integer id)
    {
        vagaService.deleteById(id);
        model.addAttribute("mensagem", "Corrida excluída com sucesso!");
        return home(model);
    }
}
