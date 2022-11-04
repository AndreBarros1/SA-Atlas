package br.atlas.repository;


import br.atlas.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepo extends JpaRepository<Feed, Long> {

}
