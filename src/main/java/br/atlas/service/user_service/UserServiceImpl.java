package br.atlas.service.user_service;


import br.atlas.model.Usuario;
import br.atlas.repository.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UsuarioService{

    private final UsuarioRepo usuarioRepo;

    public UserServiceImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario createUsuario(Usuario newUser) {
        try{
            Usuario user_data = usuarioRepo.findUsuarioByUsername(newUser.getUsername());
            if(user_data != null){
                throw new IllegalArgumentException("Erro ao criar Usuário, tente novamente");
            }
            usuarioRepo.save(newUser);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Usuário Inexistente");
        }
        return newUser;
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void deleleUsuario(Long deletedId) {
        try{
            Optional<Usuario> user_data = usuarioRepo.findById(deletedId);

            if (user_data.isEmpty()){
                throw new IllegalArgumentException("Usuário Inexistente");
            }
            usuarioRepo.delete(user_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
        try{
            Optional<Usuario> user_data = usuarioRepo.findById(id);
            if (user_data.isEmpty()){
                throw new IllegalArgumentException("Usuário Inexistente");
            }

            user_data.get().setUsername(updatedUsuario.getUsername());
            user_data.get().setEmail(updatedUsuario.getEmail());
            user_data.get().setPassword(updatedUsuario.getPassword());


            return usuarioRepo.save(user_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
    }



}
