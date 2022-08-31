package br.atlas.repository;

import br.atlas.model.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatosRepo extends JpaRepository<Contatos, Long> {
}
