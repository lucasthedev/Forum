package com.br.forum.forum.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.forum.forum.models.Curso;
import com.br.forum.forum.models.Topico;
import com.br.forum.forum.models.Usuario;
import com.br.forum.forum.repositories.CursoRepository;
import com.br.forum.forum.repositories.UsuarioRepository;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicoForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 10)
    private String mensagem;
    @NotNull @NotEmpty
    private String nomeCurso;
    
    private Long id;

    public Topico converter(CursoRepository cursoRepository, UsuarioRepository usuarioRepository){
        Curso curso = cursoRepository.findByNome(nomeCurso);
        Usuario usuario = usuarioRepository.getOne(id);
        return new Topico(titulo, mensagem, curso, usuario);
    }

}