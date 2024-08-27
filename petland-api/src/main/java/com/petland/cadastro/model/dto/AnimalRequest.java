package com.petland.cadastro.model.dto;

import com.petland.cadastro.model.AnimalEspecie;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalRequest {
    private String nome;
    private LocalDate aniversario;
    private AnimalEspecie especie;
    private Integer tutor;
}
