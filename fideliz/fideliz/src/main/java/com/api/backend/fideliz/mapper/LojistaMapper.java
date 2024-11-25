package com.api.backend.fideliz.mapper;

import com.api.backend.fideliz.model.LojistaRequest;
import com.api.backend.fideliz.model.LojistaResponse;

public class LojistaMapper {

    public static LojistaResponse toResponse(LojistaRequest lojistaRequest) {
        LojistaResponse response = new LojistaResponse();
        response.setContato(lojistaRequest.getContato());
        response.setNome(lojistaRequest.getNome());
        response.setLinkCardapio(lojistaRequest.getLinkCardapio());
        response.setLinkLogo(lojistaRequest.getLinkLogo());
        response.setLinkImage(lojistaRequest.getLinkImage());

        return response;
    }
}
