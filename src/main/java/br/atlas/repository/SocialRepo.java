package br.atlas.repository;


import br.atlas.model.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepo extends JpaRepository<Social, Long> {

}
