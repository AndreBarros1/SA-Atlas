package br.atlas.service.social_service;

import br.atlas.model.Social;
import br.atlas.repository.SocialRepo;

import java.util.List;
import java.util.Optional;

public class SocialServiceImpl implements SocialService{

    private final SocialRepo socialRepo;

    public SocialServiceImpl(SocialRepo socialRepo) {
        this.socialRepo = socialRepo;
    }

    @Override
    public Social createSocial(Social newSocial) {
        try{
            socialRepo.save(newSocial);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro ao criar Social, tente novamente.");
        }
        return newSocial;
    }

    @Override
    public List<Social> findAllSocial() {
        return socialRepo.findAll();
    }

    @Override
    public void deleteSocial(Long deletedSocial) {
        try{
            Optional<Social> social_data = socialRepo.findById(deletedSocial);
            if (social_data.isEmpty()){
                throw new IllegalArgumentException("Social Inexistente");
            }
            socialRepo.delete(social_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
    }

    @Override
    public Social updateSocial(Long id, Social updatedSocial) {
        try{
            Optional<Social> social_data = socialRepo.findById(id);
            if (social_data.isEmpty()){
                throw new IllegalArgumentException("Social Inexistente");
            }
            social_data.get().setNome(updatedSocial.getNome());


            socialRepo.save(social_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
        return updatedSocial;
    }


}
