package br.com.clouzada.senha.model.repository;

import br.com.clouzada.senha.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    Grupo findByIdAntigo(String idAntigo);
}
