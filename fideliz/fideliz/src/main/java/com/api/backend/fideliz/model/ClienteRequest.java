package com.api.backend.fideliz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequest {
    private Long idCliente;
    private String nome;
    private String cpf;
    private String contato;
    private String email;
}
