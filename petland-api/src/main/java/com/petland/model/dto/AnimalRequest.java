package com.petland.model.dto;

import com.petland.model.AnimalEspecie;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalRequest {
    private String nome;
    private LocalDate aniversario;
    private AnimalEspecie especie;
}
