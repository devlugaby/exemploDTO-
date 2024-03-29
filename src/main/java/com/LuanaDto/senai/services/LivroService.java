package com.LuanaDto.senai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.LuanaDto.senai.dto.LivroDTO;
import com.LuanaDto.senai.entities.Livro;
import com.LuanaDto.senai.repositories.LivroRepository;

@Service
public class LivroService {
	
	private final LivroRepository livroRepository;
	
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public LivroDTO salvar(Livro livro) {
		Livro salvarLivro = livroRepository.save(livro);
		return new LivroDTO(salvarLivro.getId(), salvarLivro.getTitulo(), salvarLivro.getAutor());
	}
	
	public LivroDTO atualizar(Long id, Livro livro) {
		Livro existeLivro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
		existeLivro.setTitulo(livro.getTitulo());
		existeLivro.setAutor(livro.getAutor());
		Livro updateLivro = livroRepository.save(existeLivro);
		return new LivroDTO(updateLivro.getId(), updateLivro.getTitulo(), updateLivro.getAutor());
	}
	 
	public boolean deletar(Long id) {
		java.util.Optional<Livro> existeCliente = livroRepository.findById(id);
		if (existeCliente.isPresent()) {
			livroRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Livro> buscarTodos() {
		return livroRepository.findAll();
	}
	
	public Livro buscarPorId(Long id) {
		java.util.Optional<Livro> Livro = livroRepository.findById(id);
		return Livro.orElse(null);
	}

}