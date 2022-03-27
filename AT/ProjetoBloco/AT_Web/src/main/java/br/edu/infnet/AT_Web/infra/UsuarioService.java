package br.edu.infnet.AT_Web.infra;

import br.edu.infnet.AT_Web.domain.Usuario;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {

    public Usuario autenticar(String email, String senha) {
        Map<String, Object> data = new HashMap<>();
        data.put("email", email);
        data.put("senha", senha);

        var retorno = Unirest.post("http://localhost:8082/usuario/autenticar")
                .header("Content-Type", "application/json")
                .body(data)
                .asObject(Usuario.class);


        if(retorno.getStatus() != 200){
            return null;
        }
        else{
            return retorno.getBody();
        }
    }

    public Usuario cadastrar(Usuario usuario) {
        usuario.setSituacao("A");

        var retorno = Unirest.post("http://localhost:8082/usuario/")
                .header("Content-Type", "application/json")
                .body(usuario)
                .asObject(Usuario.class);

        if(retorno.getStatus() != 200){
           return null;
        }
        else{
            return retorno.getBody();
        }
    }
}
