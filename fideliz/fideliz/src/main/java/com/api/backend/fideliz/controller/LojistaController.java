package com.api.backend.fideliz.controller;

import com.api.backend.fideliz.mapper.LojistaMapper;
import com.api.backend.fideliz.model.LojistaRequest;
import com.api.backend.fideliz.model.LojistaResponse;
import com.api.backend.fideliz.service.LojistaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/backend/fideliz")
@RequiredArgsConstructor
public class LojistaController {

    private final LojistaService service;

    @PostMapping("/criar/lojista")
    public ResponseEntity<LojistaResponse> criarLojista(@RequestBody LojistaRequest lojistaRequest) {
        service.criarLojista(lojistaRequest);
        LojistaResponse response = LojistaMapper.toResponse(lojistaRequest);

        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/atualizar/lojista")
    public ResponseEntity<String> atualizarLojista(@RequestBody LojistaRequest request) {
        service.atualizarLojista(request);

        return ResponseEntity.ok("Lojista atualizado com sucesso");
    }


}