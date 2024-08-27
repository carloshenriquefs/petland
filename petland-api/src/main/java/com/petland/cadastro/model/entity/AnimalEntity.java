package com.petland.cadastro.model.entity;

import com.petland.cadastro.model.AnimalEspecie;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tab_animal")
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 40, nullable = false)
    private String nome;

    private LocalDate aniversario;

    @Enumerated(EnumType.STRING)
    private AnimalEspecie especie;

    @Column(name = "cad_tutor")
    private Integer tutor;
}
