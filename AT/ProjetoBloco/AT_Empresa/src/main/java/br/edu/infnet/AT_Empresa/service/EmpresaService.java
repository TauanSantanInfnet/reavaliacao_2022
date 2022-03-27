package br.edu.infnet.AT_Empresa.service;

import br.edu.infnet.AT_Empresa.domain.Empresa;
import br.edu.infnet.AT_Empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa findById(Integer id){
        return (Empresa) empresaRepository.findFirstById(id);
    }

    public Empresa Cadastrar(Empresa empresa) {
        empresaRepository.save(empresa);
        return empresa;
    }
}
