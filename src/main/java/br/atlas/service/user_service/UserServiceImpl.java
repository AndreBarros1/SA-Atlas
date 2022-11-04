package br.atlas.service.user_service;


import br.atlas.model.Register;
import br.atlas.repository.LoginRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UsuarioService{

    private final LoginRepo LoginRepo;

    public UserServiceImpl(LoginRepo LoginRepo) {
        this.LoginRepo = LoginRepo;
    }

    @Override
    public Register createUsuario(Register newUser) {
        try{
            Register user_data = LoginRepo.findUsuarioByUsername(newUser.getUsername());
            if(user_data != null){
                throw new IllegalArgumentException("Erro ao criar Usuário, tente novamente");
            }
            LoginRepo.save(newUser);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Usuário Inexistente");
        }
        return newUser;
    }

    @Override
    public List<Register> findAllUsuarios() {
        return LoginRepo.findAll();
    }

    @Override
    public void deleleUsuario(Long deletedId) {
        try{
            Optional<Register> user_data = LoginRepo.findById(deletedId);

            if (user_data.isEmpty()){
                throw new IllegalArgumentException("Usuário Inexistente");
            }
            LoginRepo.delete(user_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
    }

    @Override
    public Register updateUsuario(Long id, Register updatedRegister) {
        try{
            Optional<Register> user_data = LoginRepo.findById(id);
            if (user_data.isEmpty()){
                throw new IllegalArgumentException("Usuário Inexistente");
            }

            user_data.get().setUsername(updatedRegister.getUsername());
            user_data.get().setPassword(updatedRegister.getPassword());


            return LoginRepo.save(user_data.get());
        }
        catch (Exception e){
            throw new IllegalArgumentException("Tente Novamente");
        }
    }



}
