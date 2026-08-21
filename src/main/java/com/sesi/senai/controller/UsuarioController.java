package com.sesi.senai.controller;

import com.sesi.senai.dto.UserDTO;
import com.sesi.senai.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsuarioController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO inserir(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable long id) {
        userService.delete(id);
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }


    @GetMapping("/search")
    public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) {
        return userService.queryByName(nome);
    }

    @PutMapping("/{id}")
    public UserDTO editUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return userService.editUser(id, userDTO);
    }
}
