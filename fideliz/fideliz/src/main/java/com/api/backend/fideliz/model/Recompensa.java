package com.api.backend.fideliz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recompensa {
    private Long idLojista;
    private String cnpj;
    private int quantidadeSelo;
    private String descricao;
}
