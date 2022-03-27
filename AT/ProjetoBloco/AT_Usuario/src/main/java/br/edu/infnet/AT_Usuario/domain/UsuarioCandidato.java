package br.edu.infnet.AT_Usuario.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Candidato")
public class UsuarioCandidato extends Usuario {
    public UsuarioCandidato() {
    }
}
