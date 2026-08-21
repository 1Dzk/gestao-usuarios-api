package com.sesi.senai.service;

import com.sesi.senai.dto.UserDTO;
import com.sesi.senai.model.User;
import com.sesi.senai.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());

    }

    public UserDTO findById(long id) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return UserDTO.convert(usuario);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = User.convert(userDTO);
        user = userRepository.save(user);
        return UserDTO.convert(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios.stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }

    public UserDTO editUser(long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (userDTO.getNome() != null) user.setNome(userDTO.getNome());
        if (userDTO.getCpf() != null) user.setCpf(userDTO.getCpf());
        if (userDTO.getEndereco() != null) user.setEndereco(userDTO.getEndereco());
        if (userDTO.getEmail() != null) user.setEmail(userDTO.getEmail());
        if (userDTO.getTelefone() != null) user.setTelefone(userDTO.getTelefone());

        user = userRepository.save(user);
        return UserDTO.convert(user);
    }
}

