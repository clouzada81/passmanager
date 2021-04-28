package br.com.clouzada.senha.model.repository;

import br.com.clouzada.senha.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredencialRepository extends JpaRepository<Credencial, Long> {
}
