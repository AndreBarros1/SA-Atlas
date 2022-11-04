package br.atlas.service.social_service;

import br.atlas.model.Feed;
import br.atlas.repository.FeedRepo;

import java.util.List;
import java.util.Optional;

public class SocialServiceImpl implements SocialService{

    private final FeedRepo feedRepo;

    public SocialServiceImpl(FeedRepo feedRepo) {
        this.feedRepo = feedRepo;
    }

    @Override
    public Feed createSocial(Feed newFeed) {
        try{
            feedRepo.save(newFeed);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro ao criar Social, tente novamente.");
        }
        return newFeed;
    }

    @Override
    public List<Feed> findAllSocial() {
        return feedRepo.findAll();
    }

    @Override
    public void deleteSocial(Long deletedSocial) {
        try{
            Optional<Feed> social_data = feedRepo.findById(deletedSocial);
            if (social_data.isEmpty()){
                throw new IllegalArgumentException("Social Inexistente");
            }
            feedRepo.delete(social_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
    }

    @Override
    public Feed updateSocial(Long id, Feed updatedFeed) {
        try{
            Optional<Feed> social_data = feedRepo.findById(id);
            if (social_data.isEmpty()){
                throw new IllegalArgumentException("Social Inexistente");
            }
            social_data.get().setNome(updatedFeed.getNome());


            feedRepo.save(social_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
        return updatedFeed;
    }


}
