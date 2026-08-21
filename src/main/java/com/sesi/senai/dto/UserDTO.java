package com.sesi.senai.dto;

import com.sesi.senai.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserDTO {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String cpf;
    private String telefone;
    private LocalDateTime dataCadastro;

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        return userDTO;

    }
}