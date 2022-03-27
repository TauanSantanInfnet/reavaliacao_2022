package br.edu.infnet.AT_Usuario.repository;

import br.edu.infnet.AT_Usuario.domain.Usuario;
import br.edu.infnet.AT_Usuario.domain.UsuarioAdministrador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query("from Usuario p where p.id = :id")
    public Usuario findFirstById(Integer id);

    @Query("from Usuario s where s.email = :email and s.senha = :senha")
    public Usuario findFirstByEmailAndSenha(String email, String senha);

}
