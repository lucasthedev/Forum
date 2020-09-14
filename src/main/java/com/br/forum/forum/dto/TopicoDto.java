package com.br.forum.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.br.forum.forum.models.Topico;

import lombok.Getter;

@Getter
public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String status;

    public TopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.status = topico.getStatus().toString();
    }

    public static List<TopicoDto> converter(List<Topico> topicos){
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
    }

}