package br.atlas.service.social_service;

import br.atlas.model.Feed;

import java.util.List;

public interface SocialService {
    public Feed createSocial(Feed newFeed);

    public List<Feed> findAllSocial();

    public void deleteSocial(Long deletedSocial);

    public Feed updateSocial(Long id, Feed updatedFeed);
}
