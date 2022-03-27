package br.edu.infnet.AT_Usuario.app;

import br.edu.infnet.AT_Usuario.domain.Usuario;
import br.edu.infnet.AT_Usuario.domain.UsuarioAdministrador;
import br.edu.infnet.AT_Usuario.domain.UsuarioCandidato;
import br.edu.infnet.AT_Usuario.domain.UsuarioEmpresa;
import br.edu.infnet.AT_Usuario.model.UsuarioModel;
import br.edu.infnet.AT_Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController  {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value="/usuario/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(id == null || id == 0){
            return retorno;
        }

        var usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value="/usuario/",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity incluir(@RequestBody UsuarioModel model)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if(model.getTipoUsuario().equals("") || model.getNome().equals("") || model.getEmail().equals("") || model.getSenha().equals("")){
            return retorno;
        }
        if(usuarioService.findByEmailAndSenha(model.getEmail(), model.getSenha()) != null)
        {
            return retorno;
        }

        if ("Administrador".equals(model.getTipoUsuario())) {
            if(model.getMatricula().equals("")){
                return retorno;
            }
            UsuarioAdministrador usuario = new UsuarioAdministrador();
            usuario.setNome(model.getEmail());
            usuario.setMatricula(model.getMatricula());
            usuario.setSituacao("A");
            usuario.setEmail(model.getEmail());
            usuario.setSenha(model.getSenha());
            usuario.setTipoUsuario(model.getTipoUsuario());

            usuarioService.Cadastrar(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        else if (model.getTipoUsuario().equals("Empresa")) {
            UsuarioEmpresa usuario = new UsuarioEmpresa();
            usuario.setNome(model.getEmail());
            usuario.setEmail(model.getEmail());
            usuario.setSenha(model.getSenha());
            usuario.setSituacao("A");
            usuario.setTipoUsuario(model.getTipoUsuario());

            usuarioService.Cadastrar(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        else{
            UsuarioCandidato usuario = new UsuarioCandidato();
            usuario.setNome(model.getEmail());
            usuario.setEmail(model.getEmail());
            usuario.setSenha(model.getSenha());
            usuario.setSituacao("A");
            usuario.setTipoUsuario(model.getTipoUsuario());

            usuarioService.Cadastrar(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }


    }


    @RequestMapping(value="/usuario/autenticar",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> autenticar(@RequestBody UsuarioModel model)
    {
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        if( model.getEmail().equals("") || model.getSenha().equals("")){
            return retorno;
        }



        return new ResponseEntity<Usuario>(usuarioService.autenticar(model.getEmail(), model.getSenha()), HttpStatus.OK);
    }
}
