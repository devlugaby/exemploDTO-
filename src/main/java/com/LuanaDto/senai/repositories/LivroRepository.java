package com.LuanaDto.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LuanaDto.senai.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
