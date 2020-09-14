package com.br.forum.forum.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.br.forum.forum.dto.DetalheTopicoDto;
import com.br.forum.forum.dto.TopicoDto;
import com.br.forum.forum.form.AtualizacaoTopicoForm;
import com.br.forum.forum.form.TopicoForm;
import com.br.forum.forum.models.Topico;
import com.br.forum.forum.repositories.CursoRepository;
import com.br.forum.forum.repositories.TopicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/listarTopicos")
    public List<TopicoDto> listarTopicos(String nomeCurso){
        if(nomeCurso == null){
            return TopicoDto.converter(this.topicoRepository.findAll());    
        }else{
            return TopicoDto.converter(this.topicoRepository.findByCursoNome(nomeCurso));
        }
        
    }

    @PostMapping("/cadastrarTopico")
    public ResponseEntity<TopicoDto> cadastrarTopico(@Valid @RequestBody TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.converter(cursoRepository);
        this.topicoRepository.save(topico);

        URI uri =  uriBuilder.path("/cadastrarTopico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/detalhar/{id}")
    public DetalheTopicoDto detalhar(@PathVariable Long id){
        Topico topico = topicoRepository.getOne(id);

        return new DetalheTopicoDto(topico);
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizacaoTopicoForm form){
        Topico topico = form.atualizar(id, topicoRepository);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

}