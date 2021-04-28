package br.com.clouzada.senha.service;

import br.com.clouzada.senha.exception.SenhaNotFoundException;
import br.com.clouzada.senha.model.Grupo;
import br.com.clouzada.senha.model.repository.GrupoRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {
	
	private GrupoRepository grupoRepository;
	
	@Autowired
	public GrupoServiceImpl(GrupoRepository grupoRepository) {
		super();
		this.grupoRepository = grupoRepository;
	}

	public Grupo buscar(Long id) {
		return this.grupoRepository.findById(id).orElseThrow(() ->
			new SenhaNotFoundException(id)
		);
	}
	
	public List<Grupo> listar() {
		return this.grupoRepository.findAll();
	}
	
	public void salvar(Grupo grupo) {
		this.grupoRepository.save(grupo);
	}
	
	public void alterar(Grupo grupo) {
		this.grupoRepository.save(grupo);
	}
	
	public void excluir(Grupo grupo) throws ServiceException {
		this.grupoRepository.delete(grupo);
	}
}