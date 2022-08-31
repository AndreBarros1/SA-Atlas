package br.atlas.repository;


import br.atlas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

    public Usuario findUsuarioByUsername(String username);
}
