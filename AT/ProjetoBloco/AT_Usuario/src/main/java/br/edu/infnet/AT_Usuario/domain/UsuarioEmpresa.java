package br.edu.infnet.AT_Usuario.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
@DiscriminatorValue("Empresa")
public class UsuarioEmpresa extends Usuario {
    public UsuarioEmpresa() {
    }
    @ManyToOne(cascade = CascadeType.ALL)
    public Empresa empresa;
}