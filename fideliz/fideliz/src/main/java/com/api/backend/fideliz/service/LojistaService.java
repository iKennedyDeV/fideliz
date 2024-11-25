package com.api.backend.fideliz.service;

import com.api.backend.fideliz.model.LojistaRequest;
import com.api.backend.fideliz.repository.LojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LojistaService {
    @Autowired
    private LojistaRepository repository;

    public void criarLojista(LojistaRequest lojista) {
        validateCnpjExists(lojista.getCnpj());

        Long generatedId = repository.criarLojista(lojista);
        lojista.setIdLojista(generatedId);

    }

    public void atualizarLojista(LojistaRequest request) {
        validateCnpjNotExists(request.getCnpj());

        repository.atualizarLojista(request);
    }

    private void validateCnpjExists(String cnpj) {
        boolean exist = repository.selectByCnpj(cnpj);
        if (exist) {
            throw new RuntimeException("Este cnpj já possui cadastro " + cnpj);
        }
    }

    private void validateCnpjNotExists(String cnpj) {
        boolean exist = repository.selectByCnpj(cnpj);
        if (!exist) {
            throw new RuntimeException("Este lojista não possui cadastro com o cnpj: " + cnpj);
        }
    }
}
