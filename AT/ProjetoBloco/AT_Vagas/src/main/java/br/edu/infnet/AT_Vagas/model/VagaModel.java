package br.edu.infnet.AT_Vagas.model;

import java.sql.Date;

public class VagaModel {
    public Integer id;

    public String vagaSituacao;
    public String descricao;
    public String requisitos;
    public String dataCadastro;
    public String dataFinal;
    public Integer empresaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVagaSituacao() {
        return vagaSituacao;
    }

    public void setVagaSituacao(String vagaSituacao) {
        this.vagaSituacao = vagaSituacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Integer getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Integer empresaId) {
        this.empresaId = empresaId;
    }
}
