package com.br.forum.forum.dto;

import lombok.Getter;

@Getter
public class ErroFormDto {

    private String campo;
    private String erro;

    public ErroFormDto(String campo, String erro){
        this.campo = campo;
        this.erro = erro;
    }

}