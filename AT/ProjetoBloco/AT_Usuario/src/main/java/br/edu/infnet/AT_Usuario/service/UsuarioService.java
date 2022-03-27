package br.edu.infnet.AT_Usuario.service;

import br.edu.infnet.AT_Usuario.domain.Usuario;
import br.edu.infnet.AT_Usuario.domain.UsuarioAdministrador;
import br.edu.infnet.AT_Usuario.domain.UsuarioCandidato;
import br.edu.infnet.AT_Usuario.domain.UsuarioEmpresa;
import br.edu.infnet.AT_Usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String email, String senha){
        return (Usuario) usuarioRepository.findFirstByEmailAndSenha(email, senha);
    }

    public Usuario findById(Integer id){
        return (Usuario) usuarioRepository.findFirstById(id);
    }

    public Usuario findByEmailAndSenha(String email, String senha){
        return (Usuario) usuarioRepository.findFirstByEmailAndSenha(email, senha);
    }

    public Usuario Cadastrar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }
}
