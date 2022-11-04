package br.atlas.repository;

import br.atlas.model.Edit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditRepo extends JpaRepository<Edit, Long> {
}
