package br.atlas.service.post_service;

import java.util.List;

public interface PostService {

    public Post createPost(Post newPost);

    public List<Post> findAllPost();

    public void deletePost(Long id);

    public Post updatePost(Long id, Post updatedPost);



}
