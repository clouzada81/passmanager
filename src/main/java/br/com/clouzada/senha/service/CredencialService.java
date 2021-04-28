package br.com.clouzada.senha.service;

import br.com.clouzada.senha.exception.SenhaException;
import br.com.clouzada.senha.model.Credencial;
import br.com.clouzada.senha.model.command.SenhaCommand;

import java.util.List;

public interface CredencialService {
	public Credencial buscar(Long id);
	public List<Credencial> listar();
	public void salvar(Credencial credesncial);
	public void alterar(Credencial credesncial);
	public void excluir(Credencial credesncial);
	public String gerarSenha(SenhaCommand senhaCommand);
}