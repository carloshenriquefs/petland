package com.petland.model.dto;

import com.petland.model.Endereco;
import com.petland.model.Perfil;
import lombok.Data;

@Data
public class CadastroRequest {
    private Integer id;
    private String nome;
    private Perfil perfil;
    private Endereco endereco;

}
