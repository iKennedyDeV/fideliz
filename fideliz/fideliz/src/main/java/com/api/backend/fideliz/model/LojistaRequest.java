package com.api.backend.fideliz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class LojistaRequest {
    private Long idLojista;
    private String nome;
    private String cnpj;
    private String contato;
    private String linkCardapio;
    private String linkImage;
    private String linkLogo;
    private List<Recompensa> listRecompensa = new ArrayList<>();
}

