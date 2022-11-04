package br.atlas.repository;


import br.atlas.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long> {
}
