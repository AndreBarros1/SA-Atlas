package br.atlas.controller;

import br.atlas.model.Usuario;
import br.atlas.service.user_service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UserServiceImpl userService;

    public UsuarioController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUsuario(Usuario newUsuario){
        return ResponseEntity.ok(userService.createUsuario(newUsuario));
    }
    @GetMapping("/read")
    public ResponseEntity<List<Usuario>> readUsuario(){
        return ResponseEntity.ok(userService.findAllUsuarios());
    }
    @PutMapping("/update{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long id, Usuario updateUsuario){
        return ResponseEntity.ok(userService.updateUsuario(id, updateUsuario));
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id){
        userService.deleleUsuario(id);
        return ResponseEntity.ok("Usuario Foi Deletado");
    }
}