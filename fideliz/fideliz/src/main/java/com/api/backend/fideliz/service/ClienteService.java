package com.api.backend.fideliz.service;

import com.api.backend.fideliz.model.ClienteRequest;
import com.api.backend.fideliz.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public void criarCliente(ClienteRequest request) {
        validateClienteExists(request.getCpf());

        Long generatedId = repository.criarCliente(request);
        request.setIdCliente(generatedId);
    }

    private void validateClienteExists(String cpf) {
        boolean exists = repository.selectClienteByCpf(cpf);
        if (exists) {
            throw new RuntimeException("Esse cliente já existe, cpf: " + cpf);
        }
    }
}
