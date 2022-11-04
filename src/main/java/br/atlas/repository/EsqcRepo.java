package br.atlas.repository;

import br.atlas.model.Esqc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsqcRepo extends JpaRepository<Esqc, Long> {
}
