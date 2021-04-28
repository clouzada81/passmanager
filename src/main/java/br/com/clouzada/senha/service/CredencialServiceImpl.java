package br.com.clouzada.senha.service;

import br.com.clouzada.senha.exception.SenhaNotFoundException;
import br.com.clouzada.senha.model.Credencial;
import br.com.clouzada.senha.model.command.SenhaCommand;
import br.com.clouzada.senha.model.repository.CredencialRepository;
import br.com.clouzada.senha.util.GeradorSenha;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredencialServiceImpl implements CredencialService {

	private CredencialRepository credencialRepository;

	@Autowired
	public CredencialServiceImpl(CredencialRepository grupoRepository) {
		super();
		this.credencialRepository = grupoRepository;
	}

	public Credencial buscar(Long id) {
		return this.credencialRepository.findById(id).orElseThrow(() ->
			new SenhaNotFoundException(id)
		);
	}
	
	public List<Credencial> listar() {
		return this.credencialRepository.findAll();
	}
	
	public void salvar(Credencial credencial) {
		if (credencial.getSenhaUsuario() == null || credencial.getSenhaUsuario().isEmpty()) {
			credencial.getSenhaCommand().setSenha(this.gerarSenha(credencial.getSenhaCommand()));
			credencial.setSenhaUsuario(credencial.getSenhaCommand().getSenha());
		}
		this.credencialRepository.save(credencial);
	}
	
	public void alterar(Credencial credencial) {
		if (credencial.getSenhaUsuario() == null || credencial.getSenhaUsuario().isEmpty()) {
			credencial.getSenhaCommand().setSenha(this.gerarSenha(credencial.getSenhaCommand()));
			credencial.setSenhaUsuario(credencial.getSenhaCommand().getSenha());
		}
		this.credencialRepository.save(credencial);
	}
	
	public void excluir(Credencial credencial) throws ServiceException {
		this.credencialRepository.delete(credencial);
	}

	public String gerarSenha(SenhaCommand senhaCommand) {
		return GeradorSenha.gerarSenha(senhaCommand.getTamanhoSenha(), senhaCommand.getMinusculas(),
				senhaCommand.getMaiusculas(), senhaCommand.getNumeros(), senhaCommand.getCaracteresEspeciais());
	}
}