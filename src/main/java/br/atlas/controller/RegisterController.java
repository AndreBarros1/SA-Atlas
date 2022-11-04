package br.atlas.controller;


import br.atlas.model.Register;
import br.atlas.service.user_service.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Register")
public class RegisterController {

    private final UserServiceImpl userService;

    public RegisterController(UserServiceImpl userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Register> createUsuario(Register newRegister){
        return ResponseEntity.ok(userService.createUsuario(newRegister));
    }

    @GetMapping("/read")
    public ResponseEntity<List<Register>> readUsuario(){
        return ResponseEntity.ok(userService.findAllUsuarios());
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Register> updateUsuario(@PathVariable("id") Long id, Register updateRegister){
        return ResponseEntity.ok(userService.updateUsuario(id, updateRegister));
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("id") Long id){
        userService.deleleUsuario(id);
        return ResponseEntity.ok("Usuario Foi Deletado");
    }
}
