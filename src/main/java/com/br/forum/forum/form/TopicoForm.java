package com.br.forum.forum.form;

import com.br.forum.forum.models.Curso;
import com.br.forum.forum.models.Topico;
import com.br.forum.forum.repositories.CursoRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository){
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }

}