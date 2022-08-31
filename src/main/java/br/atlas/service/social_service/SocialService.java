package br.atlas.service.social_service;

import br.atlas.model.Social;

import java.util.List;

public interface SocialService {
    public Social createSocial(Social newSocial);

    public List<Social> findAllSocial();

    public void deleteSocial(Long deletedSocial);

    public Social updateSocial(Long id, Social updatedSocial);
}
