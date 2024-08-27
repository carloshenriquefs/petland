package com.petland.cadastro.repository;

import com.petland.cadastro.model.entity.CadastroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<CadastroEntity, Integer> {
}
