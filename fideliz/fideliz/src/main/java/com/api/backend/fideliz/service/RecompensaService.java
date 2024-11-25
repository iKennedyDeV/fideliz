package com.api.backend.fideliz.service;

import com.api.backend.fideliz.model.Recompensa;
import com.api.backend.fideliz.repository.LojistaRepository;
import com.api.backend.fideliz.repository.RecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class RecompensaService {
    @Autowired RecompensaRepository recompensaRepository;
    @Autowired LojistaRepository lojistaRepository;

    public void adicionarRecompensa(Recompensa recompensa) {
        validateCnpjLojista(recompensa.getCnpj());

        Long idLojista = lojistaRepository.findIdByCnpj(recompensa.getCnpj());
        recompensa.setIdLojista(idLojista);

        Recompensa recompensaExistente = recompensaRepository.findByIdLojista(recompensa.getIdLojista());
        if (recompensaExistente != null) {
            recompensaExistente.setQuantidadeSelo(recompensaExistente.getQuantidadeSelo() + recompensa.getQuantidadeSelo());
            recompensaExistente.setDescricao(recompensa.getDescricao());
            recompensaRepository.atualizarRecompensa(recompensaExistente);
        } else {
            recompensaRepository.adicionarRecompensa(recompensa);
        }
    }

    private void validateCnpjLojista(String cnpj) {
        Long id = lojistaRepository.findIdByCnpj(cnpj);
        if (id == null) {
            throw new RuntimeException("Lojista não encontrado");
        }
    }
}
