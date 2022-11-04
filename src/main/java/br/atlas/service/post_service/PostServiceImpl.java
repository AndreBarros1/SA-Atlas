package br.atlas.service.post_service;

import br.atlas.repository.EditRepo;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService{

    private final EditRepo editRepo;

    public PostServiceImpl(EditRepo editRepo) {
        this.editRepo = editRepo;
    }

    @Override
    public Post createPost(Post newPost) {

        try{
           editRepo.save(newPost);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Erro ao criar Post, tente Novamente.");
        }
        return newPost;
    }

    @Override
    public List<Post> findAllPost() {
        return findAllPost();
    }

    @Override
    public void deletePost(Long id) {

        try {
            Optional<Post> post_data = editRepo.findById(id);
            if (post_data.isEmpty()){
                throw new IllegalArgumentException("Post Inexistente");
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }

    }

    @Override
    public Post updatePost(Long id, Post updatedPost) {
        try{
            Optional<Post> post_data = editRepo.findById(id);
            if(post_data.isEmpty()){
                throw new IllegalArgumentException("Post Inexistente");
            }


           editRepo.save(post_data.get());

        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }


        return updatedPost;
    }

}
