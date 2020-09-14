package com.br.forum.forum.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.forum.forum.models.Topico;
import com.br.forum.forum.repositories.TopicoRepository;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoTopicoForm {
    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 10)
    private String mensagem;

	public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
		return topico;
	}
}