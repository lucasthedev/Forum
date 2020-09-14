package com.br.forum.forum.repositories;

import java.util.List;

import com.br.forum.forum.models.Topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    public List<Topico> findByCursoNome(String nomeCurso);
}