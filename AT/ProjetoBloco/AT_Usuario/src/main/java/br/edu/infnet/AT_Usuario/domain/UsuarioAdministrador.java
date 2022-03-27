package br.edu.infnet.AT_Usuario.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Administrador")
public class UsuarioAdministrador extends Usuario {
    public UsuarioAdministrador() {

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String matricula;

}


