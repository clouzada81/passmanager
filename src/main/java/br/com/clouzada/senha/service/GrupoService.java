package br.com.clouzada.senha.service;

import br.com.clouzada.senha.exception.SenhaException;
import br.com.clouzada.senha.model.Grupo;

import java.util.List;

public interface GrupoService {
	public Grupo buscar(Long id);
	public List<Grupo> listar();
	public void salvar(Grupo grupo);
	public void alterar(Grupo grupo);
	public void excluir(Grupo grupo);
}