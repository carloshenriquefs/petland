package com.petland.cadastro.repository;

import com.petland.cadastro.model.ProdutoServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, Integer> {
}
