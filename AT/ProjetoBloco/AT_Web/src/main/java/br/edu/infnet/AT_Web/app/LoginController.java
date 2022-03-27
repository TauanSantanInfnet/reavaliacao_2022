package br.edu.infnet.AT_Web.app;

import br.edu.infnet.AT_Web.domain.Usuario;
import br.edu.infnet.AT_Web.infra.UsuarioService;
import br.edu.infnet.AT_Web.model.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(value="/login/CadastroUsuario")
    public String CadastroSolicitanteGet(Model model)
    {
        return "Usuario/CadastroUsuario";
    }

    @PostMapping(value="/login/CadastroUsuario")
    public String CadastroUsuarioPost(Model model, Usuario usuario)
    {
        var usuarioDb = usuarioService.cadastrar(usuario);
        if(usuarioDb == null){
            model.addAttribute("mensagem", "Erro ao cadastrar o usuário. Verifique os dados informados");
            return CadastroSolicitanteGet(model);
        }else{
            model.addAttribute("usuario",usuarioDb);
            return "home";
        }


    }

    @PostMapping(value="/login")
    public String login(Model model, Usuario loginModel)
    {
        var usuarioDb = usuarioService.autenticar(loginModel.getEmail(), loginModel.getSenha());

        if(usuarioDb == null){
            model.addAttribute("mensagem", "Erro ao logar o usuário. Verifique os dados informados");
            return "index";
        }else{
            model.addAttribute("usuario",usuarioDb);
            return "home";
        }
    }
}
