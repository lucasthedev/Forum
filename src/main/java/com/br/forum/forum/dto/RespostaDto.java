package com.br.forum.forum.dto;

import java.time.LocalDateTime;

import com.br.forum.forum.models.Resposta;

import lombok.Getter;

@Getter
public class RespostaDto {

    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public RespostaDto(Resposta resposta){
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
    }

}