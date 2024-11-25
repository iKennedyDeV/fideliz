package com.api.backend.fideliz.controller;

import com.api.backend.fideliz.model.Recompensa;
import com.api.backend.fideliz.service.RecompensaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/backend/fideliz")
@RequiredArgsConstructor
public class RecompensaController {

    private final RecompensaService service;

    @PostMapping("/adicionar/recompensa")
    public ResponseEntity<String> adicionarRecompensa(@RequestBody Recompensa recompensa) {
        service.adicionarRecompensa(recompensa);

        return ResponseEntity.ok("Recompensa adicionada com sucesso!");
    }
}