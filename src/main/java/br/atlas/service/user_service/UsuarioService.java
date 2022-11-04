package br.atlas.service.user_service;

import br.atlas.model.Register;

import java.util.List;

public interface UsuarioService {

    public Register createUsuario(Register newUser);

    public List<Register> findAllUsuarios();

    public void deleleUsuario(Long deletedId);

    public Register updateUsuario(Long id, Register updatedRegister);

}
