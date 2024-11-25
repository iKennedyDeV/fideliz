package com.api.backend.fideliz.controller;

import com.api.backend.fideliz.model.ClienteRequest;
import com.api.backend.fideliz.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/backend/fideliz")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping("/criar/cliente")
    public ResponseEntity<String> criarLojista(@RequestBody ClienteRequest request) {
        service.criarCliente(request);

        return ResponseEntity.status(201).body("Cliente criado com sucesso");
    }
}