package br.atlas.service.user_service;

import br.atlas.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario createUsuario(Usuario newUser);

    public List<Usuario> findAllUsuarios();

    public void deleleUsuario(Long deletedId);

    public Usuario updateUsuario(Long id, Usuario updatedUsuario);

}
