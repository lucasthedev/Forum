package com.br.forum.forum.controllers;

import java.util.Arrays;
import java.util.List;

import com.br.forum.forum.dto.TopicoDto;
import com.br.forum.forum.models.Curso;
import com.br.forum.forum.models.Topico;
import com.br.forum.forum.repositories.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping("/listarTopicos")
    public List<TopicoDto> listarTopicos(){
        return TopicoDto.converter(this.topicoRepository.findAll());
    }

}